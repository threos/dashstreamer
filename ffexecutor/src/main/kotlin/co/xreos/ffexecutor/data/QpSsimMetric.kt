package co.xreos.ffexecutor.data

import co.xreos.ffexecutor.data.base.IMetric
import co.xreos.ffexecutor.option.FfmpegQuantizationParameterOption

class QpSsimMetric(
    private val quantizationParameterOption: FfmpegQuantizationParameterOption,
    private val ssim: Double
): IMetric<Int, Double> {
    override fun getX(): Int = quantizationParameterOption.quantizationParameter
    override fun getY(): Double = ssim
}