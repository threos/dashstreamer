package co.xreos.option

import co.xreos.option.base.IFfmpegOption

class FfmpegGOPLengthOption(
    val gopLength: Int
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-g $gopLength -keyint_min $gopLength"
    }
}