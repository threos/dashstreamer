package co.xreos.option

import co.xreos.option.base.IFfmpegOption

class FfmpegNoOutputOption: IFfmpegOption {
    override fun getRepresentation(): String {
        return "NoOutput"
    }
}