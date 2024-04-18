package com.xreos.ffexecutor.data

import com.xreos.ffexecutor.data.base.IMetric
import com.xreos.ffexecutor.option.FfmpegQuantizationParameterOption

class QpSsimMetric(
    private val quantizationParameterOption: FfmpegQuantizationParameterOption,
    private val ssim: Double
): IMetric<Int, Double> {
    override fun getX(): Int = quantizationParameterOption.quantizationParameter
    override fun getY(): Double = ssim
}