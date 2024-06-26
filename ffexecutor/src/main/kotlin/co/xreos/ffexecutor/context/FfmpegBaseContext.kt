package co.xreos.ffexecutor.context

import co.xreos.ffexecutor.option.base.IFfmpegOption
import java.util.*

open class FfmpegBaseContext(
    val id: String = UUID.randomUUID().toString(),
    val options: List<IFfmpegOption> = emptyList(),
)