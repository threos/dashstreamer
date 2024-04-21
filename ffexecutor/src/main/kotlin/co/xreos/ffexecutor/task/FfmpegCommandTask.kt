package co.xreos.ffexecutor.task

import co.xreos.ffexecutor.option.base.IFfmpegOption
import co.xreos.ffexecutor.task.base.IFfmpegTask

class FfmpegCommandTask private constructor() : IFfmpegTask {
    private val definition: MutableList<String> = mutableListOf("ffmpeg")
    constructor(command: String): this() {
        definition.add(command)
    }

    constructor(definition: List<String>): this() {
        this.definition.addAll(definition)
    }

    constructor(vararg definition: Any): this() {
        this.definition.addAll(definition.flatMap {
            when (it) {
                is String -> listOf(it)
                is IFfmpegOption -> it.getRepresentation().split(" ")
                else -> throw IllegalArgumentException("Invalid argument type: ${it::class.simpleName}")
            }
        })
    }

    override fun getDefinition(): List<String> {
        return definition
    }
}