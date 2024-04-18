package co.xreos.option

import co.xreos.constant.FfmpegCodec
import co.xreos.constant.FfmpegPixelFormat
import co.xreos.option.base.IFfmpegOption
import java.io.File

class FfmpegInputOption(
    private val file: File
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-i ${file.absolutePath}"
    }
}