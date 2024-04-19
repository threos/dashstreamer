package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegReferenceFramesOption(
    val referenceFrames: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-refs $referenceFrames"
    }
}