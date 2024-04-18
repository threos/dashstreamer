package com.xreos.ffexecutor.context

import com.xreos.ffexecutor.option.base.IFfmpegOption
import java.io.File
import java.util.*

open class FfmpegBaseContext(
    val id: String = UUID.randomUUID().toString(),
    val options: List<IFfmpegOption> = emptyList(),
)