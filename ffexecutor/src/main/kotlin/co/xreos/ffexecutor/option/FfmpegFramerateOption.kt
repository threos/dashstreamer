package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegFramerateOption(
    private val framerate: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-framerate $framerate"
    }
}