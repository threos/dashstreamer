package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegCodecOption(
    val ffmpegCodec: co.xreos.ffexecutor.constant.FfmpegCodec
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-c:v ${ffmpegCodec.codec}"
    }
}