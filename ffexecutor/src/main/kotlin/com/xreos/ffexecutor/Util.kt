package co.xreos.com.xreos.ffexecutor

import co.xreos.context.FfmpegBaseContext
import com.xreos.ffexecutor.store.MetricStore
import java.io.File
import java.util.*

lateinit var currentRunDate: Date
lateinit var taskId: String

val metricStore = com.xreos.ffexecutor.store.MetricStore()
fun mkdir() {
    val outputDir = defaultOutputFolder()
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
fun defaultOutputFolder(): String = "output/${currentRunDate.toString().replace(" ", "_").replace(":", "_")}/$taskId"
fun defaultOutputProvider(input: File, context: FfmpegBaseContext): File =
    File("${defaultOutputFolder()}/video/${filenameProvider(input, context)}.mp4")
fun defaultOutputMetadataProvider(input: File, context: FfmpegBaseContext): File =
    File("${defaultOutputFolder()}/metadata/${filenameProvider(input, context)}.txt")
fun defaultAnalysisProvider(title: String): File =
    File("${defaultOutputFolder()}/analysis/${title.lowercase().replace(" ", "_").replace("-", "_").replace(".", "")}.png")