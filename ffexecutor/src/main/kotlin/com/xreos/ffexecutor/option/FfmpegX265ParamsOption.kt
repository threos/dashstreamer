package com.xreos.ffexecutor.option

import com.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegX265ParamsOption: IFfmpegOption {
    override fun getRepresentation(): String {
        return "-x265-params"
    }
}