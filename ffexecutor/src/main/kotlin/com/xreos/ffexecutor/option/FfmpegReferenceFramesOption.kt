package co.xreos.option

import co.xreos.option.base.IFfmpegOption

class FfmpegReferenceFramesOption(
    val referenceFrames: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-refs $referenceFrames"
    }
}