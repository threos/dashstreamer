package co.xreos.ffexecutor.option.transform

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegTransformedStreamOption(
    val stream: Int,
    val option: IFfmpegOption
): IFfmpegOption {
    override fun getRepresentation(): String {
        return option.getRepresentation().split(" ")
            .takeIf { it.isNotEmpty() }?.let {
            it[0] + ":$stream " + it.drop(1).joinToString(" ")
        } ?: throw IllegalArgumentException("Invalid option")
    }

}