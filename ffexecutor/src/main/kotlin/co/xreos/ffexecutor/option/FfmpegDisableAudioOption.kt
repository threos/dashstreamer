package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegDisableAudioOption: IFfmpegOption {
    override fun getRepresentation(): String {
        return "-an"
    }
}