package co.xreos.ffexecutor.matrix

import co.xreos.ffexecutor.context.FfmpegBaseContext
import java.io.File

data class FfmpegTaskMatrix(
    val inputs: List<File>,
    val contexts: List<FfmpegBaseContext>,
    val sourceContexts: List<FfmpegBaseContext>? = null,
    val outputProvider: (File, FfmpegBaseContext) -> File,
    val outputMetadataProvider: (File, FfmpegBaseContext) -> File,
    )