package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption
import java.io.File

class FfmpegFileInputOption(
    private val file: File
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-i ${file.absolutePath}"
    }
}