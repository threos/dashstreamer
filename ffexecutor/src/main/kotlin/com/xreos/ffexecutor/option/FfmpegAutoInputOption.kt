package com.xreos.ffexecutor.option

import com.xreos.ffexecutor.option.base.IFfmpegOption
import java.io.File

class FfmpegAutoInputOption: IFfmpegOption {
    override fun getRepresentation(): String {
        return "AutoInputOption"
    }

    fun getRepresentation(file: File): String {
        return "-i ${file.absolutePath}"
    }
}