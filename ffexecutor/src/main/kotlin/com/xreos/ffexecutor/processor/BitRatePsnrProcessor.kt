package com.xreos.ffexecutor.processor

import com.xreos.ffexecutor.context.FfmpegContext
import com.xreos.ffexecutor.data.BitRatePsnrMetric
import com.xreos.ffexecutor.processor.base.IProcessor
import net.bramp.ffmpeg.FFprobe

class BitRatePsnrProcessor: IProcessor<BitRatePsnrMetric> {
    private val ffProbe = FFprobe()
    override fun process(ffmpegContext: FfmpegContext, data: String): BitRatePsnrMetric {
        val psnrY = data.split("PSNR y:")[1].split(" ")[0].toDouble()
        val bitRate = ffProbe.probe(ffmpegContext.sourceContext!!.output.absolutePath).let {
            it.streams.first().bit_rate.toDouble() / 1000000.0
        }
        return BitRatePsnrMetric(ffmpegContext.input.nameWithoutExtension, (ffmpegContext.sourceContext.options.first { it is com.xreos.ffexecutor.option.FfmpegCodecOption } as com.xreos.ffexecutor.option.FfmpegCodecOption).ffmpegCodec, bitRate, psnrY)
    }
}