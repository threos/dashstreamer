package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegVideoSizeOption(
    private val width: Int,
    private val height: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-video_size ${width}x${height}"
    }
}