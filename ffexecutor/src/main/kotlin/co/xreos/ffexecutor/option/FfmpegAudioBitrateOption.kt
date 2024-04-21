package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegAudioBitrateOption(
    private var bitrate: String
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-b:a $bitrate"
    }

    constructor(megaBitPerSecond: Int? = null, kBitPerSecond: Int? = null) : this(
        ""
    ) {
        if(megaBitPerSecond != null && kBitPerSecond != null) {
            throw IllegalArgumentException("Only one of megaBitPerSecond or kBitPerSecond should be provided")
        } else if(megaBitPerSecond == null && kBitPerSecond == null) {
            throw IllegalArgumentException("Either megaBitPerSecond or kBitPerSecond should be provided")
        }
        bitrate = if(megaBitPerSecond != null) "${megaBitPerSecond}M" else "${kBitPerSecond}k"
    }
}