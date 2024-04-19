package co.xreos.ffexecutor.task

class FfmpegCommandTask private constructor() : IFfmpegTask {
    private val definition: MutableList<String> = mutableListOf("ffmpeg")
    constructor(command: String): this() {
        definition.add(command)
    }

    constructor(definition: List<String>): this() {
        this.definition.addAll(definition)
    }

    override fun getDefinition(): List<String> {
        return definition
    }
}