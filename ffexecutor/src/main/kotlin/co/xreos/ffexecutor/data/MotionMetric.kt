package co.xreos.ffexecutor.data

import co.xreos.ffexecutor.data.base.IMetric
import co.xreos.ffexecutor.option.FfmpegMotionEstimationMethodOption
import co.xreos.ffexecutor.option.FfmpegMotionEstimationRangeOption

class MotionMetric(
    private val ffmpegMotionEstimationMethodOption: FfmpegMotionEstimationMethodOption,
    private val ffmpegMotionEstimationRangeOption: FfmpegMotionEstimationRangeOption,
    private val bitRate: Double
): IMetric<String, Double> {
    override fun getX(): String = "${ffmpegMotionEstimationMethodOption.motionEstimationMethod} ${ffmpegMotionEstimationRangeOption.motionEstimationRange}"
    override fun getY(): Double = bitRate
}