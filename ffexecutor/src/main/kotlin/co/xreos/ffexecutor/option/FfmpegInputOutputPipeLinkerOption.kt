package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption
import java.io.File

@Deprecated("This option is not needed and not supported by FfmpegExecutor.run anymore.")
class FfmpegInputOutputPipeLinkerOption: IFfmpegOption {
    override fun getRepresentation(): String {
        return "FfmpegInputOutputPipeLinkerOption"
    }
}