package co.xreos.data

import co.xreos.data.base.IMetric
import co.xreos.option.FfmpegReferenceFramesOption

class ReferenceFrameBitRateMetric(
    private val referenceFramesOption: FfmpegReferenceFramesOption,
    private val bitRate: Double
): IMetric<Int, Double> {
    override fun getX(): Int = referenceFramesOption.referenceFrames
    override fun getY(): Double = bitRate
}