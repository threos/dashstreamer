package com.xreos.ffexecutor.option

import com.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegX265ParamsQuantizationParameterOption(
    private val quantizationParameter: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "qp $quantizationParameter"
    }
}