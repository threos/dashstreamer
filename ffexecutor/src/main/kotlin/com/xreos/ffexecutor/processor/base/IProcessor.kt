package co.xreos.processor.base

import co.xreos.context.FfmpegContext

interface IProcessor<T> {
    fun process(ffmpegContext: FfmpegContext, data: String): T
}