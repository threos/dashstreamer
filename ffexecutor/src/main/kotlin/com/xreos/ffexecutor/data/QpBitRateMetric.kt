package co.xreos.data

import co.xreos.data.base.IMetric
import co.xreos.option.FfmpegQuantizationParameterOption

class QpBitRateMetric(
    private val quantizationParameterOption: FfmpegQuantizationParameterOption,
    private val bitRate: Double
): IMetric<Int, Double> {
    override fun getX(): Int = quantizationParameterOption.quantizationParameter
    override fun getY(): Double = bitRate
}