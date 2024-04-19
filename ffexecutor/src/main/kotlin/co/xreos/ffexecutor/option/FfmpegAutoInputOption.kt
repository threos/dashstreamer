package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption
import java.io.File

class FfmpegAutoInputOption: IFfmpegOption {
    override fun getRepresentation(): String {
        return "AutoInputOption"
    }

    fun getRepresentation(file: File): String {
        return "-i ${file.absolutePath}"
    }
}