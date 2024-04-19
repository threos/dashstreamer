package co.xreos.ffexecutor.entity

data class TaskResult (
    val success: Boolean,
    val output: String,
    val errorOutput: String,
    val exitCode: Int,
)