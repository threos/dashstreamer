package com.xreos.ffexecutor.option

import com.xreos.ffexecutor.constant.FfmpegMotionEstimationMethod
import com.xreos.ffexecutor.option.base.IFfmpegOption


class FfmpegMotionEstimationMethodOption(
    val motionEstimationMethod: FfmpegMotionEstimationMethod
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-me_method ${motionEstimationMethod.method}"
    }
}