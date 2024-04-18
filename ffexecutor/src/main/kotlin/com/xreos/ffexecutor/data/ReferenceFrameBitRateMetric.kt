package com.xreos.ffexecutor.data

import com.xreos.ffexecutor.data.base.IMetric
import com.xreos.ffexecutor.option.FfmpegReferenceFramesOption

class ReferenceFrameBitRateMetric(
    private val referenceFramesOption: FfmpegReferenceFramesOption,
    private val bitRate: Double
): IMetric<Int, Double> {
    override fun getX(): Int = referenceFramesOption.referenceFrames
    override fun getY(): Double = bitRate
}