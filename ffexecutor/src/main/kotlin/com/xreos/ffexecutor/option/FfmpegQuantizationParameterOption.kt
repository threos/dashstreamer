package co.xreos.option

import co.xreos.constant.FfmpegCodec
import co.xreos.constant.FfmpegPixelFormat
import co.xreos.option.base.IFfmpegOption

class FfmpegQuantizationParameterOption(
    val quantizationParameter: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-qp $quantizationParameter"
    }
}