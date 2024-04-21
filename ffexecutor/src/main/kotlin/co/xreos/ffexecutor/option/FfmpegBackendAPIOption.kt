package co.xreos.ffexecutor.option

import co.xreos.ffexecutor.option.base.IFfmpegOption
import java.io.File

class FfmpegBackendAPIOption(
    private val backend: String
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-f $backend"
    }
}