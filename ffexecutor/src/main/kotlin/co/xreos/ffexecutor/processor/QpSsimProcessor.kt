package co.xreos.ffexecutor.processor

import co.xreos.ffexecutor.context.FfmpegEncodeContext
import co.xreos.ffexecutor.data.QpSsimMetric
import co.xreos.ffexecutor.option.FfmpegQuantizationParameterOption
import co.xreos.ffexecutor.processor.base.IProcessor

class QpSsimProcessor: IProcessor<QpSsimMetric> {
    override fun process(ffmpegEncodeContext: FfmpegEncodeContext, data: String): QpSsimMetric {
        val quantizationParameterOption = (ffmpegEncodeContext.sourceContext?.options?.firstOrNull { it is FfmpegQuantizationParameterOption } ?: ffmpegEncodeContext.options.firstOrNull { it is FfmpegQuantizationParameterOption }) as FfmpegQuantizationParameterOption
        val ssim = data.split("SSIM Y:")[1].split("All:")[1].split(" ")[0].toDouble()
        return QpSsimMetric(quantizationParameterOption, ssim)
    }
}