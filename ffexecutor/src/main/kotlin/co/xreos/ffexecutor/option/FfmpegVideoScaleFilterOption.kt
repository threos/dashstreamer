package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegVideoScaleFilterOption(
    private val width: Int,
    private val height: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-filter:v scale=$width:$height"
    }
}