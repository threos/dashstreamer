package com.xreos.ffexecutor.option

import com.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegNoOutputOption: IFfmpegOption {
    override fun getRepresentation(): String {
        return "NoOutput"
    }
}