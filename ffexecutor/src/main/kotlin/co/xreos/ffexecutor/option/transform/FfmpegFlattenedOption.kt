package co.xreos.ffexecutor.option.transform

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegFlattenedOption(
    val options: List<IFfmpegOption>
): IFfmpegOption {
    override fun getRepresentation(): String {
        return options.joinToString(" ") { it.getRepresentation() }
    }

}