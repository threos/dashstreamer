package co.xreos.ffexecutor.data

import co.xreos.ffexecutor.constant.FfmpegCodec
import co.xreos.ffexecutor.data.base.IMetric

class BitRatePsnrMetric(
    val videoName: String,
    val codec: co.xreos.ffexecutor.constant.FfmpegCodec,
    private val bitRate: Double,
    private val psnr: Double
): IMetric<Double, Double> {
    override fun getX(): Double = bitRate
    override fun getY(): Double = psnr
}