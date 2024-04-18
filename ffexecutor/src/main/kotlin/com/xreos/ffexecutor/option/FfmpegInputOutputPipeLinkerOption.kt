package com.xreos.ffexecutor.option

import com.xreos.ffexecutor.option.base.IFfmpegOption
import java.io.File

class FfmpegInputOutputPipeLinkerOption: IFfmpegOption {
    override fun getRepresentation(): String {
        return "FfmpegInputOutputPipeLinkerOption"
    }
}