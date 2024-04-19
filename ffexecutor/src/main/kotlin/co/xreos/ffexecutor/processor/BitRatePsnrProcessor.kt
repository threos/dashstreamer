package co.xreos.ffexecutor.processor

import co.xreos.ffexecutor.context.FfmpegEncodeContext
import co.xreos.ffexecutor.data.BitRatePsnrMetric
import co.xreos.ffexecutor.processor.base.IProcessor
import net.bramp.ffmpeg.FFprobe

class BitRatePsnrProcessor: IProcessor<BitRatePsnrMetric> {
    private val ffProbe = FFprobe()
    override fun process(ffmpegEncodeContext: FfmpegEncodeContext, data: String): BitRatePsnrMetric {
        val psnrY = data.split("PSNR y:")[1].split(" ")[0].toDouble()
        val bitRate = ffProbe.probe(ffmpegEncodeContext.sourceContext!!.output.absolutePath).let {
            it.streams.first().bit_rate.toDouble() / 1000000.0
        }
        return BitRatePsnrMetric(ffmpegEncodeContext.input.nameWithoutExtension, (ffmpegEncodeContext.sourceContext.options.first { it is co.xreos.ffexecutor.option.FfmpegCodecOption } as co.xreos.ffexecutor.option.FfmpegCodecOption).ffmpegCodec, bitRate, psnrY)
    }
}