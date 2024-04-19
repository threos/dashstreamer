package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.constant.FfmpegMotionEstimationMethod
import co.xreos.ffexecutor.option.base.IFfmpegOption


class FfmpegMotionEstimationMethodOption(
    val motionEstimationMethod: FfmpegMotionEstimationMethod
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-me_method ${motionEstimationMethod.method}"
    }
}