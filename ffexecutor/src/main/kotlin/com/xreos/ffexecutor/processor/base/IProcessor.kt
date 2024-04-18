package com.xreos.ffexecutor.processor.base

import com.xreos.ffexecutor.context.FfmpegContext

interface IProcessor<T> {
    fun process(ffmpegContext: FfmpegContext, data: String): T
}