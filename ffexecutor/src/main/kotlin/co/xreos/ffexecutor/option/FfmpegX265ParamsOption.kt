package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegX265ParamsOption: IFfmpegOption {
    override fun getRepresentation(): String {
        return "-x265-params"
    }
}