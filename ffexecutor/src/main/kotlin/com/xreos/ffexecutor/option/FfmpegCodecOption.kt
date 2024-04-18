package com.xreos.ffexecutor.option

import com.xreos.ffexecutor.option.base.IFfmpegOption

class FfmpegCodecOption(
    val ffmpegCodec: com.xreos.ffexecutor.constant.FfmpegCodec
): IFfmpegOption {
    override fun getRepresentation(): String {
        return "-c:v ${ffmpegCodec.codec}"
    }
}