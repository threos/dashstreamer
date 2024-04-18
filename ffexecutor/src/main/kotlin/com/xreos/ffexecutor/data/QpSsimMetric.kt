package co.xreos.data

import co.xreos.data.base.IMetric
import co.xreos.option.FfmpegQuantizationParameterOption

class QpSsimMetric(
    private val quantizationParameterOption: FfmpegQuantizationParameterOption,
    private val ssim: Double
): IMetric<Int, Double> {
    override fun getX(): Int = quantizationParameterOption.quantizationParameter
    override fun getY(): Double = ssim
}