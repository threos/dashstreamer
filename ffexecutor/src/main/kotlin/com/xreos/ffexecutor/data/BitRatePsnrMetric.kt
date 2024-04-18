package co.xreos.data

import co.xreos.constant.FfmpegCodec
import co.xreos.data.base.IMetric
import co.xreos.option.FfmpegQuantizationParameterOption

class BitRatePsnrMetric(
    val videoName: String,
    val codec: FfmpegCodec,
    private val bitRate: Double,
    private val psnr: Double
): IMetric<Double, Double> {
    override fun getX(): Double = bitRate
    override fun getY(): Double = psnr
}