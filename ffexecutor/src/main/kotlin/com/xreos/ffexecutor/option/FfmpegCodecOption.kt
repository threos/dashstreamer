package co.xreos.option

import co.xreos.constant.FfmpegCodec
import co.xreos.option.base.IFfmpegOption

class FfmpegCodecOption(
    val ffmpegCodec: FfmpegCodec
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-c:v ${ffmpegCodec.codec}"
    }
}