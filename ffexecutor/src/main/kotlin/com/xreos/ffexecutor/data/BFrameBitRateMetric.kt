package co.xreos.data

import co.xreos.data.base.IMetric
import co.xreos.option.FfmpegBFramesOption
import co.xreos.option.FfmpegReferenceFramesOption

class BFrameBitRateMetric(
    private val bFramesOption: FfmpegBFramesOption,
    private val bitRate: Double
): IMetric<Int, Double> {
    override fun getX(): Int = bFramesOption.bFrames
    override fun getY(): Double = bitRate
}