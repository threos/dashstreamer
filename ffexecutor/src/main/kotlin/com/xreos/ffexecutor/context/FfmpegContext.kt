package co.xreos.context

import co.xreos.option.base.IFfmpegOption
import java.io.File
import java.util.*

data class FfmpegContext(
    val id: String = UUID.randomUUID().toString(),
    val input: File,
    val output: File,
    val metadataOutput: File?,
    val options: List<IFfmpegOption> = emptyList(),
    val sourceContext: FfmpegContext? = null,
)