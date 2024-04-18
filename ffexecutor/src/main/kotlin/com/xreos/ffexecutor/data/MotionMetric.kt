package co.xreos.data

import co.xreos.constant.FfmpegMotionEstimationMethod
import co.xreos.data.base.IMetric
import co.xreos.option.FfmpegMotionEstimationMethodOption
import co.xreos.option.FfmpegMotionEstimationRangeOption
import co.xreos.option.FfmpegReferenceFramesOption

class MotionMetric(
    private val ffmpegMotionEstimationMethodOption: FfmpegMotionEstimationMethodOption,
    private val ffmpegMotionEstimationRangeOption: FfmpegMotionEstimationRangeOption,
    private val bitRate: Double
): IMetric<String, Double> {
    override fun getX(): String = "${ffmpegMotionEstimationMethodOption.motionEstimationMethod} ${ffmpegMotionEstimationRangeOption.motionEstimationRange}"
    override fun getY(): Double = bitRate
}