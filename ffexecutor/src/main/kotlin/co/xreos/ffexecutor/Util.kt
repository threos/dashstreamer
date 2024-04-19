package co.xreos.ffexecutor

import co.xreos.ffexecutor.context.FfmpegBaseContext
import java.io.File
import java.util.*

lateinit var currentRunDate: Date
lateinit var taskId: String

val metricStore = co.xreos.ffexecutor.store.MetricStore()
fun mkdir() {
    val outputDir = co.xreos.ffexecutor.defaultOutputFolder()
    File(outputDir).takeUnless {
        it.exists()
    }?.mkdirs()
    File("$outputDir/video").takeUnless {
        it.exists()
    }?.mkdir()
    File("$outputDir/metadata").takeUnless {
        it.exists()
    }?.mkdir()
    File("$outputDir/analysis").takeUnless {
        it.exists()
    }?.mkdir()
}
fun filenameProvider(input: File, context: FfmpegBaseContext): String = "${input.nameWithoutExtension}_${
    context.options.map {
        it.getRepresentation().replace(" ", "_")
    }.joinToString(separator = "") {
        it
    }
}"
fun defaultOutputFolder(): String = "output/${co.xreos.ffexecutor.currentRunDate.toString().replace(" ", "_").replace(":", "_")}/${co.xreos.ffexecutor.taskId}"
fun defaultOutputProvider(input: File, context: FfmpegBaseContext): File =
    File("${co.xreos.ffexecutor.defaultOutputFolder()}/video/${co.xreos.ffexecutor.filenameProvider(input, context)}.mp4")
fun defaultOutputMetadataProvider(input: File, context: FfmpegBaseContext): File =
    File("${co.xreos.ffexecutor.defaultOutputFolder()}/metadata/${co.xreos.ffexecutor.filenameProvider(input, context)}.txt")
fun defaultAnalysisProvider(title: String): File =
    File("${co.xreos.ffexecutor.defaultOutputFolder()}/analysis/${title.lowercase().replace(" ", "_").replace("-", "_").replace(".", "")}.png")