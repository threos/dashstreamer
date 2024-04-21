package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegHWInputOption(
    private val camera: String,
    private val audio: String
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-i $camera:$audio"
    }
}