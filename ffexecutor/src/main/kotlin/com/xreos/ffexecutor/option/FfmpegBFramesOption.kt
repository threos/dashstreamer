package co.xreos.option

import co.xreos.option.base.IFfmpegOption

class FfmpegBFramesOption(
    val bFrames: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-bf $bFrames"
    }
}