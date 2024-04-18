package co.xreos.option

import co.xreos.constant.FfmpegMotionEstimationMethod
import co.xreos.option.base.IFfmpegOption

class FfmpegMotionEstimationRangeOption(
    val motionEstimationRange: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-me_range $motionEstimationRange"
    }
}