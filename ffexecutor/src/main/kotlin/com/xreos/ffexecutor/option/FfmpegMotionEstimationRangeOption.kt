package com.xreos.ffexecutor.option

import com.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegMotionEstimationRangeOption(
    val motionEstimationRange: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-me_range $motionEstimationRange"
    }
}