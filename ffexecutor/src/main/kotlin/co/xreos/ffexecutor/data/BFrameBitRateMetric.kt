package co.xreos.ffexecutor.data

import co.xreos.ffexecutor.data.base.IMetric
import co.xreos.ffexecutor.option.FfmpegBFramesOption


class BFrameBitRateMetric(
    private val bFramesOption: FfmpegBFramesOption,
    private val bitRate: Double
): IMetric<Int, Double> {
    override fun getX(): Int = bFramesOption.bFrames
    override fun getY(): Double = bitRate
}