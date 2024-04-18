package co.xreos.option

import co.xreos.option.base.IFfmpegOption

class FfmpegX265ParamsOption: IFfmpegOption {
    override fun getRepresentation(): String {
        return "-x265-params"
    }
}