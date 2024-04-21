package co.xreos.ffexecutor.option.builder

import co.xreos.ffexecutor.option.FfmpegVideoBitrateOption
import co.xreos.ffexecutor.option.FfmpegVideoScaleFilterOption
import co.xreos.ffexecutor.option.base.IFfmpegOption
import co.xreos.ffexecutor.option.transform.FfmpegFlattenedOption
import co.xreos.ffexecutor.option.transform.FfmpegTransformedStreamOption

class FfmpegStreamBuilder(
    private val index: Int,
) {
    private val options = mutableListOf<IFfmpegOption>()

    fun withVideoBitrate(megaBitPerSecond: Int? = null, kBitPerSecond: Int? = null): FfmpegStreamBuilder {
        if(megaBitPerSecond != null && kBitPerSecond != null) {
            throw IllegalArgumentException("Only one of megaBitPerSecond or kBitPerSecond should be provided")
        } else if(megaBitPerSecond == null && kBitPerSecond == null) {
            throw IllegalArgumentException("Either megaBitPerSecond or kBitPerSecond should be provided")
        }
        options.add(FfmpegTransformedStreamOption(
            index,
            FfmpegVideoBitrateOption(
                if(megaBitPerSecond != null) "${megaBitPerSecond}M" else "${kBitPerSecond}k"
            )
        ))
        return this
    }

    fun withVideoScaleFilter(width: Int, height: Int): FfmpegStreamBuilder {
        options.add(FfmpegTransformedStreamOption(
            index,
            FfmpegVideoScaleFilterOption(width, height),
        ))
        return this
    }

    fun build(): IFfmpegOption {
        return FfmpegFlattenedOption(options)
    }
}