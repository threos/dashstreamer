package com.xreos.ffexecutor.option

import com.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegCustomOption(
    private val option: String,
): IFfmpegOption {
    override fun getRepresentation(): String {
        return option
    }
}