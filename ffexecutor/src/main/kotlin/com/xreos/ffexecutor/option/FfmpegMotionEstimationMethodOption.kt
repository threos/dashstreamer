package co.xreos.option

import co.xreos.constant.FfmpegMotionEstimationMethod
import co.xreos.option.base.IFfmpegOption

class FfmpegMotionEstimationMethodOption(
    val motionEstimationMethod: FfmpegMotionEstimationMethod
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-me_method ${motionEstimationMethod.method}"
    }
}