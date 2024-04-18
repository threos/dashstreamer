package co.xreos.option

import co.xreos.option.base.IFfmpegOption

class FfmpegCustomOption(
    private val option: String,
): IFfmpegOption {
    override fun getRepresentation(): String {
        return option
    }
}