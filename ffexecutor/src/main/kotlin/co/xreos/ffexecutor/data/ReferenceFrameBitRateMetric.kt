package co.xreos.ffexecutor.data

import co.xreos.ffexecutor.data.base.IMetric
import co.xreos.ffexecutor.option.FfmpegReferenceFramesOption

class ReferenceFrameBitRateMetric(
    private val referenceFramesOption: FfmpegReferenceFramesOption,
    private val bitRate: Double
): IMetric<Int, Double> {
    override fun getX(): Int = referenceFramesOption.referenceFrames
    override fun getY(): Double = bitRate
}