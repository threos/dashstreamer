package com.xreos.ffexecutor.option

import com.xreos.ffexecutor.constant.FfmpegPixelFormat
import com.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegPixelFormatOption(
    private val ffmpegPixelFormat: FfmpegPixelFormat
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-pix_fmt ${ffmpegPixelFormat.pixelFormat}"
    }
}