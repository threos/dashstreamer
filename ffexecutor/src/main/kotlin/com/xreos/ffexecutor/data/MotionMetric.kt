package com.xreos.ffexecutor.data

import com.xreos.ffexecutor.data.base.IMetric
import com.xreos.ffexecutor.option.FfmpegMotionEstimationMethodOption
import com.xreos.ffexecutor.option.FfmpegMotionEstimationRangeOption

class MotionMetric(
    private val ffmpegMotionEstimationMethodOption: FfmpegMotionEstimationMethodOption,
    private val ffmpegMotionEstimationRangeOption: FfmpegMotionEstimationRangeOption,
    private val bitRate: Double
): IMetric<String, Double> {
    override fun getX(): String = "${ffmpegMotionEstimationMethodOption.motionEstimationMethod} ${ffmpegMotionEstimationRangeOption.motionEstimationRange}"
    override fun getY(): Double = bitRate
}