package co.xreos.ffexecutor.execution

import co.xreos.ffexecutor.context.FfmpegEncodeContext
import co.xreos.ffexecutor.entity.TaskResult
import co.xreos.ffexecutor.matrix.FfmpegTaskMatrix
import co.xreos.ffexecutor.option.FfmpegAutoInputOption
import co.xreos.ffexecutor.option.FfmpegInputOutputPipeLinkerOption
import co.xreos.ffexecutor.option.FfmpegNoOutputOption
import co.xreos.ffexecutor.task.IFfmpegTask
import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger
import java.io.File


object FfmpegExecutor {
    private val logger: Logger = getLogger(FfmpegExecutor::class.java.name)
    fun run(task: IFfmpegTask, path: File? = null): TaskResult {
        logger.debug("Running: ${task.getDefinition().joinToString(separator = " ")}")
        path?.takeUnless { it.exists() }?.mkdirs()
        val process = ProcessBuilder(task.getDefinition()).directory(path).start()
        var success = false
        try {
            success = process.waitFor() == 0
        } catch (e: Exception) {
            process.outputWriter().append("q")?.also {
                it.flush()
                it.close()
            }
            process.destroy()
            logger.warn("Process error", e)
        }
        val output = process.inputStream.readAllBytes().let {
            String(it)
        }
        val errorOutput = process.errorStream.readAllBytes().let {
            String(it)
        }
        logger.info(output)
        logger.warn(errorOutput)
        return TaskResult(success, output, errorOutput, process.exitValue())
    }

    @Suppress("MemberVisibilityCanBePrivate")
    @Deprecated("Use FfmpegExecutor.run(task: IFfmpegTask) instead")
    fun execute(ffmpegEncodeContext: FfmpegEncodeContext, processor: ((FfmpegEncodeContext, String) -> Unit)? = null, throwExceptionOnFailure: Boolean = false) {
        val input = ffmpegEncodeContext.options.firstOrNull { it is FfmpegInputOutputPipeLinkerOption }?.let {
            ffmpegEncodeContext.output
        } ?: ffmpegEncodeContext.input
        val command = mutableListOf("ffmpeg", "-i", input.absolutePath)
        command.addAll(ffmpegEncodeContext.options.mapNotNull {
            when (it) {
                is FfmpegAutoInputOption -> {
                    it.getRepresentation(ffmpegEncodeContext.input).split(" ")
                }
                is FfmpegInputOutputPipeLinkerOption -> {
                    null
                }
                is FfmpegNoOutputOption -> {
                    null
                }
                else -> it.getRepresentation().split(" ")
            }
        }.flatten())
        if(ffmpegEncodeContext.options.firstOrNull { it is FfmpegInputOutputPipeLinkerOption || it is FfmpegNoOutputOption } == null) command.add(ffmpegEncodeContext.output.absolutePath)
        println("Executing: ${command.joinToString(separator = " ")}")
        val process = ProcessBuilder(command).start()
        val success = process.waitFor() == 0
        val output = ""
        if (processor == null) {
            ffmpegEncodeContext.metadataOutput?.run {
                this.createNewFile()
                this.outputStream().also {
                    process.errorStream.transferTo(it)
                    process.inputStream.transferTo(it)
                    it.flush()
                    it.close()
                }
            }
        } else {
            processor.invoke(ffmpegEncodeContext, "${process.inputStream.readAllBytes().also {
                String(it)
            }}\n${process.errorStream.readAllBytes().let {
                String(it)
            }}")
        }
        if(!success && throwExceptionOnFailure) throw Exception("Failed to execute: ${command.joinToString(separator = " ")}")
    }

    fun execute(ffmpegTaskMatrix: FfmpegTaskMatrix, processor: ((FfmpegEncodeContext, String) -> Unit)? = null) {
        ffmpegTaskMatrix.inputs.map { input ->
            ffmpegTaskMatrix.contexts.mapIndexed { index, it ->
                val sourceBaseContext = ffmpegTaskMatrix.sourceContexts?.let { sourceContexts ->
                    sourceContexts[index]
                }
                val sourceContext = sourceBaseContext?.let {
                    FfmpegEncodeContext(
                        id = it.id,
                        input = input,
                        output = ffmpegTaskMatrix.outputProvider(input, it),
                        metadataOutput = ffmpegTaskMatrix.outputMetadataProvider(input, it),
                        options = it.options,
                    )
                }
                FfmpegEncodeContext(
                    id = it.id,
                    input = input,
                    output = ffmpegTaskMatrix.outputProvider(input, sourceBaseContext ?: it),
                    metadataOutput = ffmpegTaskMatrix.outputMetadataProvider(input, sourceBaseContext ?: it),
                    options = it.options,
                    sourceContext = sourceContext,
                )
            }
        }.flatten().forEach {
            FfmpegExecutor.execute(it, processor)
        }
    }
}