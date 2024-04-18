package com.xreos.ffexecutor.processor

import com.xreos.ffexecutor.context.FfmpegContext
import com.xreos.ffexecutor.data.QpSsimMetric
import com.xreos.ffexecutor.option.FfmpegQuantizationParameterOption
import com.xreos.ffexecutor.processor.base.IProcessor

class QpSsimProcessor: IProcessor<QpSsimMetric> {
    override fun process(ffmpegContext: FfmpegContext, data: String): QpSsimMetric {
        val quantizationParameterOption = (ffmpegContext.sourceContext?.options?.firstOrNull { it is FfmpegQuantizationParameterOption } ?: ffmpegContext.options.firstOrNull { it is FfmpegQuantizationParameterOption }) as FfmpegQuantizationParameterOption
        val ssim = data.split("SSIM Y:")[1].split("All:")[1].split(" ")[0].toDouble()
        return QpSsimMetric(quantizationParameterOption, ssim)
    }
}