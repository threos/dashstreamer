package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.constant.FfmpegPixelFormat
import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegPixelFormatOption(
    private val ffmpegPixelFormat: FfmpegPixelFormat
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-pix_fmt ${ffmpegPixelFormat.pixelFormat}"
    }
}