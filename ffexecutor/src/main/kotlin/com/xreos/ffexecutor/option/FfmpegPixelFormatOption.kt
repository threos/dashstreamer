package co.xreos.option

import co.xreos.constant.FfmpegCodec
import co.xreos.constant.FfmpegPixelFormat
import co.xreos.option.base.IFfmpegOption

class FfmpegPixelFormatOption(
    private val ffmpegPixelFormat: FfmpegPixelFormat
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-pix_fmt ${ffmpegPixelFormat.pixelFormat}"
    }
}