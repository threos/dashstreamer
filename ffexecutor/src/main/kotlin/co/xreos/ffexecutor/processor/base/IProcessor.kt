package co.xreos.ffexecutor.processor.base

import co.xreos.ffexecutor.context.FfmpegEncodeContext

interface IProcessor<T> {
    fun process(ffmpegEncodeContext: FfmpegEncodeContext, data: String): T
}