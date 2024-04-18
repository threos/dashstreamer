package co.xreos.execution

import co.xreos.context.FfmpegContext
import co.xreos.matrix.FfmpegTaskMatrix
import co.xreos.option.FfmpegAutoInputOption
import co.xreos.option.FfmpegInputOutputPipeLinkerOption
import co.xreos.option.FfmpegNoOutputOption

object FfmpegExecutor {
    @Suppress("MemberVisibilityCanBePrivate")
    fun execute(ffmpegContext: FfmpegContext, processor: ((FfmpegContext, String) -> Unit)? = null) {
        val input = ffmpegContext.options.firstOrNull { it is FfmpegInputOutputPipeLinkerOption }?.let {
            ffmpegContext.output
        } ?: ffmpegContext.input
        val command = mutableListOf("ffmpeg", "-i", input.absolutePath)
        command.addAll(ffmpegContext.options.mapNotNull {
            when (it) {
                is FfmpegAutoInputOption -> {
                    it.getRepresentation(ffmpegContext.input).split(" ")
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
        if(ffmpegContext.options.firstOrNull { it is FfmpegInputOutputPipeLinkerOption || it is FfmpegNoOutputOption } == null) command.add(ffmpegContext.output.absolutePath)
        println("Executing: ${command.joinToString(separator = " ")}")
        val process = ProcessBuilder(command).start()
        process.waitFor()
        val output = ""/*String(process.inputStream.readAllBytes())*/
        if (processor == null) {
            ffmpegContext.metadataOutput?.run {
                this.createNewFile()
                this.outputStream().also {
                    process.errorStream.transferTo(it)
                    process.inputStream.transferTo(it)
                    it.flush()
                    it.close()
                }
            }
        } else {
            processor.invoke(ffmpegContext, "${process.inputStream.readAllBytes().also {
                String(it)
            }}\n${process.errorStream.readAllBytes().let {
                String(it)
            }}")
        }
    }

    fun execute(ffmpegTaskMatrix: FfmpegTaskMatrix, processor: ((FfmpegContext, String) -> Unit)? = null) {
        ffmpegTaskMatrix.inputs.map { input ->
            ffmpegTaskMatrix.contexts.mapIndexed { index, it ->
                val sourceBaseContext = ffmpegTaskMatrix.sourceContexts?.let { sourceContexts ->
                    sourceContexts[index]
                }
                val sourceContext = sourceBaseContext?.let {
                    FfmpegContext(
                        id = it.id,
                        input = input,
                        output = ffmpegTaskMatrix.outputProvider(input, it),
                        metadataOutput = ffmpegTaskMatrix.outputMetadataProvider(input, it),
                        options = it.options,
                    )
                }
                FfmpegContext(
                    id = it.id,
                    input = input,
                    output = ffmpegTaskMatrix.outputProvider(input, sourceBaseContext ?: it),
                    metadataOutput = ffmpegTaskMatrix.outputMetadataProvider(input, sourceBaseContext ?: it),
                    options = it.options,
                    sourceContext = sourceContext,
                )
            }
        }.flatten().forEach {
            execute(it, processor)
        }
    }
}