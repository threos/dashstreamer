package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegBFramesOption(
    val bFrames: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-bf $bFrames"
    }
}