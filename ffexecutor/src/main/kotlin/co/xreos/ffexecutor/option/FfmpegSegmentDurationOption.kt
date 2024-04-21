package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegSegmentDurationOption(
    private val duration: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-seg_duration $duration"
    }
}