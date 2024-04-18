package co.xreos.data

import co.xreos.data.base.IMetric
import co.xreos.option.FfmpegGOPLengthOption
import co.xreos.option.FfmpegQuantizationParameterOption

class GopLengthBitRateMetric(
    private val gopLengthOption: FfmpegGOPLengthOption,
    private val bitRate: Double
): IMetric<Int, Double> {
    override fun getX(): Int = gopLengthOption.gopLength
    override fun getY(): Double = bitRate
}