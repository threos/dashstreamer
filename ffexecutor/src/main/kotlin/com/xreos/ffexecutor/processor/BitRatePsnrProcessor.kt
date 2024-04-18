package co.xreos.processor

import co.xreos.constant.FfmpegCodec
import co.xreos.context.FfmpegContext
import co.xreos.data.BitRatePsnrMetric
import co.xreos.data.QpBitRateMetric
import co.xreos.data.QpPsnrMetric
import co.xreos.data.QpSsimMetric
import co.xreos.metricStore
import co.xreos.option.FfmpegCodecOption
import co.xreos.option.FfmpegQuantizationParameterOption
import co.xreos.processor.base.IProcessor
import co.xreos.taskId
import net.bramp.ffmpeg.FFprobe

class BitRatePsnrProcessor: IProcessor<BitRatePsnrMetric> {
    private val ffProbe = FFprobe()
    override fun process(ffmpegContext: FfmpegContext, data: String): BitRatePsnrMetric {
        val psnrY = data.split("PSNR y:")[1].split(" ")[0].toDouble()
        val bitRate = ffProbe.probe(ffmpegContext.sourceContext!!.output.absolutePath).let {
            it.streams.first().bit_rate.toDouble() / 1000000.0
        }
        return BitRatePsnrMetric(ffmpegContext.input.nameWithoutExtension, (ffmpegContext.sourceContext.options.first { it is FfmpegCodecOption } as FfmpegCodecOption).ffmpegCodec, bitRate, psnrY)
    }
}