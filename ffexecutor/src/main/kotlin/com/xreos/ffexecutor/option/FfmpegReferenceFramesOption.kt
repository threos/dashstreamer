package com.xreos.ffexecutor.option

import com.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegReferenceFramesOption(
    val referenceFrames: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-refs $referenceFrames"
    }
}