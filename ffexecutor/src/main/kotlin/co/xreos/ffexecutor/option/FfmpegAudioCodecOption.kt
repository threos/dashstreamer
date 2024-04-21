package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegAudioCodecOption(
    val codec: co.xreos.ffexecutor.constant.FfmpegAudioCodec
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-c:a ${codec.codec}"
    }
}