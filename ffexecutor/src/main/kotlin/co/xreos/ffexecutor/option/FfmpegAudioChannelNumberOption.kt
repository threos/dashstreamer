package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegAudioChannelNumberOption(
    private val channels: Int,
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-ac $channels"
    }
}