package com.xreos.ffexecutor.option

import com.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegDisableAudioOption: IFfmpegOption {
    override fun getRepresentation(): String {
        return "-an"
    }
}