package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegNoOutputOption: IFfmpegOption {
    override fun getRepresentation(): String {
        return "NoOutput"
    }
}