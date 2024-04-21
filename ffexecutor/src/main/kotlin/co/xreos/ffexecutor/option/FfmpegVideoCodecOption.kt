package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegVideoCodecOption(
    val codec: co.xreos.ffexecutor.constant.FfmpegVideoCodec
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-c:v ${codec.codec}"
    }
}