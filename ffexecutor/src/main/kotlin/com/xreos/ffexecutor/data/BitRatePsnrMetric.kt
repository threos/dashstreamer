package com.xreos.ffexecutor.data

import com.xreos.ffexecutor.constant.FfmpegCodec
import com.xreos.ffexecutor.data.base.IMetric

class BitRatePsnrMetric(
    val videoName: String,
    val codec: com.xreos.ffexecutor.constant.FfmpegCodec,
    private val bitRate: Double,
    private val psnr: Double
): IMetric<Double, Double> {
    override fun getX(): Double = bitRate
    override fun getY(): Double = psnr
}