package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption
import java.io.File

class FfmpegInputOption(
    private val file: File
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-i ${file.absolutePath}"
    }
}