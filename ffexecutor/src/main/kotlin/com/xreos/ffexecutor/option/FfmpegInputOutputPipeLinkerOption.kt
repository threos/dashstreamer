package co.xreos.option

import co.xreos.constant.FfmpegCodec
import co.xreos.constant.FfmpegPixelFormat
import co.xreos.option.base.IFfmpegOption
import java.io.File

class FfmpegInputOutputPipeLinkerOption: IFfmpegOption {
    override fun getRepresentation(): String {
        return "FfmpegInputOutputPipeLinkerOption"
    }
}