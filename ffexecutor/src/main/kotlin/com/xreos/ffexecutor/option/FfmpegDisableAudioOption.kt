package co.xreos.option

import co.xreos.option.base.IFfmpegOption

class FfmpegDisableAudioOption: IFfmpegOption {
    override fun getRepresentation(): String {
        return "-an"
    }
}