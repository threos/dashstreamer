package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegVideoBitrateOption(
    private val bitrate: String
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-b:v $bitrate"
    }
}