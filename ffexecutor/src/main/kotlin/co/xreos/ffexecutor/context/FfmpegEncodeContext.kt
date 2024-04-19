package co.xreos.ffexecutor.context

import co.xreos.ffexecutor.option.base.IFfmpegOption
import java.io.File
import java.util.*

data class FfmpegEncodeContext(
    val id: String = UUID.randomUUID().toString(),
    val input: File,
    val output: File,
    val metadataOutput: File?,
    val options: List<IFfmpegOption> = emptyList(),
    val sourceContext: FfmpegEncodeContext? = null,
)