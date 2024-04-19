package co.xreos.ffexecutor.data

import co.xreos.ffexecutor.data.base.IMetric
import co.xreos.ffexecutor.option.FfmpegGOPLengthOption

class GopLengthBitRateMetric(
    private val gopLengthOption: FfmpegGOPLengthOption,
    private val bitRate: Double
): IMetric<Int, Double> {
    override fun getX(): Int = gopLengthOption.gopLength
    override fun getY(): Double = bitRate
}