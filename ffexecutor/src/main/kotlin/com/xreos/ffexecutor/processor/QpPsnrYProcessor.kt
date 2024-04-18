package co.xreos.processor

import co.xreos.context.FfmpegContext
import co.xreos.data.QpPsnrMetric
import co.xreos.option.FfmpegQuantizationParameterOption
import co.xreos.processor.base.IProcessor

class QpPsnrYProcessor: IProcessor<QpPsnrMetric> {
    override fun process(ffmpegContext: FfmpegContext, data: String): QpPsnrMetric {
        val quantizationParameterOption = (ffmpegContext.sourceContext?.options?.firstOrNull { it is FfmpegQuantizationParameterOption } ?: ffmpegContext.options.firstOrNull { it is FfmpegQuantizationParameterOption }) as FfmpegQuantizationParameterOption
        val psnrY = data.split("PSNR y:")[1].split(" ")[0].toDouble()
        return QpPsnrMetric(quantizationParameterOption, psnrY)
    }
}