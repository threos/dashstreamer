package com.xreos.ffexecutor.processor

import com.xreos.ffexecutor.context.FfmpegContext
import com.xreos.ffexecutor.data.QpPsnrMetric
import com.xreos.ffexecutor.option.FfmpegQuantizationParameterOption
import com.xreos.ffexecutor.processor.base.IProcessor

class QpPsnrYProcessor: IProcessor<QpPsnrMetric> {
    override fun process(ffmpegContext: FfmpegContext, data: String): QpPsnrMetric {
        val quantizationParameterOption = (ffmpegContext.sourceContext?.options?.firstOrNull { it is FfmpegQuantizationParameterOption } ?: ffmpegContext.options.firstOrNull { it is FfmpegQuantizationParameterOption }) as FfmpegQuantizationParameterOption
        val psnrY = data.split("PSNR y:")[1].split(" ")[0].toDouble()
        return QpPsnrMetric(quantizationParameterOption, psnrY)
    }
}