package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegMotionEstimationRangeOption(
    val motionEstimationRange: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-me_range $motionEstimationRange"
    }
}