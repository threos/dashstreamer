package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

@Deprecated("This option is not needed and not supported by FfmpegExecutor.run anymore.")
class FfmpegNoOutputOption: IFfmpegOption {
    override fun getRepresentation(): String {
        return "NoOutput"
    }
}