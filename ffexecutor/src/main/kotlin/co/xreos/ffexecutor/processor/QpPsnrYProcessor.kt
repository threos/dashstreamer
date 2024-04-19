package co.xreos.ffexecutor.processor

import co.xreos.ffexecutor.context.FfmpegEncodeContext
import co.xreos.ffexecutor.data.QpPsnrMetric
import co.xreos.ffexecutor.option.FfmpegQuantizationParameterOption
import co.xreos.ffexecutor.processor.base.IProcessor

class QpPsnrYProcessor: IProcessor<QpPsnrMetric> {
    override fun process(ffmpegEncodeContext: FfmpegEncodeContext, data: String): QpPsnrMetric {
        val quantizationParameterOption = (ffmpegEncodeContext.sourceContext?.options?.firstOrNull { it is FfmpegQuantizationParameterOption } ?: ffmpegEncodeContext.options.firstOrNull { it is FfmpegQuantizationParameterOption }) as FfmpegQuantizationParameterOption
        val psnrY = data.split("PSNR y:")[1].split(" ")[0].toDouble()
        return QpPsnrMetric(quantizationParameterOption, psnrY)
    }
}