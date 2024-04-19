package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegQuantizationParameterOption(
    val quantizationParameter: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-qp $quantizationParameter"
    }
}