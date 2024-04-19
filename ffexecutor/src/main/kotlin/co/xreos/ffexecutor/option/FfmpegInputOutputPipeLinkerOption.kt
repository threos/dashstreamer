package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption
import java.io.File

class FfmpegInputOutputPipeLinkerOption: IFfmpegOption {
    override fun getRepresentation(): String {
        return "FfmpegInputOutputPipeLinkerOption"
    }
}