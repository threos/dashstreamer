package com.xreos.ffexecutor.option

import com.xreos.ffexecutor.option.base.IFfmpegOption
import java.io.File

class FfmpegInputOption(
    private val file: File
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-i ${file.absolutePath}"
    }
}