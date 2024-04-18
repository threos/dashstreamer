package com.xreos.ffexecutor.option

import com.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegGOPLengthOption(
    val gopLength: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-g $gopLength -keyint_min $gopLength"
    }
}