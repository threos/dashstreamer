package com.xreos.ffexecutor.data

import com.xreos.ffexecutor.data.base.IMetric
import com.xreos.ffexecutor.option.FfmpegGOPLengthOption

class GopLengthBitRateMetric(
    private val gopLengthOption: FfmpegGOPLengthOption,
    private val bitRate: Double
): IMetric<Int, Double> {
    override fun getX(): Int = gopLengthOption.gopLength
    override fun getY(): Double = bitRate
}