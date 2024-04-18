package com.xreos.ffexecutor.data

import com.xreos.ffexecutor.data.base.IMetric
import com.xreos.ffexecutor.option.FfmpegBFramesOption


class BFrameBitRateMetric(
    private val bFramesOption: FfmpegBFramesOption,
    private val bitRate: Double
): IMetric<Int, Double> {
    override fun getX(): Int = bFramesOption.bFrames
    override fun getY(): Double = bitRate
}