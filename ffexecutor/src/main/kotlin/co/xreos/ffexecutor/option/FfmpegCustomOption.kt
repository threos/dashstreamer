package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegCustomOption(
    private val option: String,
): IFfmpegOption {
    override fun getRepresentation(): String {
        return option
    }
}