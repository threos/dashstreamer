package com.xreos.ffexecutor.option

import com.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegBFramesOption(
    val bFrames: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-bf $bFrames"
    }
}