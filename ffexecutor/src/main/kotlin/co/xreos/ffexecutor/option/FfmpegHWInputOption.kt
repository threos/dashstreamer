package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegHWInputOption(
    private val camera: String,
    private val audio: String? = null,
): IFfmpegOption {
    override fun getRepresentation(): String {
        val osName = System.getProperty("os.name").lowercase()
        if(osName.contains("windows")) {
            return "-i video=$camera:audio=$audio"
        } else if (osName.contains("mac")) {
            return "-i $camera:${audio ?: "default"}"
        } else if (osName.contains("nix") || osName.contains("nux")) {
            return "-i /dev/video$camera -f pulse -i ${audio ?: "default"}"
        }
        throw UnsupportedOperationException("FfmpegHWInputOption does not support this operation system: $osName")
    }
}