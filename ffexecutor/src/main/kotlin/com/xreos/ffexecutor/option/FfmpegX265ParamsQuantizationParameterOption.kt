package co.xreos.option

import co.xreos.option.base.IFfmpegOption

class FfmpegX265ParamsQuantizationParameterOption(
    private val quantizationParameter: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "qp $quantizationParameter"
    }
}