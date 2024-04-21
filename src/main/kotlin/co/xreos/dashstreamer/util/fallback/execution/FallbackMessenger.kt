package co.xreos.dashstreamer.util.fallback.execution

import co.xreos.ffexecutor.entity.TaskResult

class FallbackMessenger {
    private var message = FallbackMessageType.FAILURE
    fun success() {
        message = FallbackMessageType.SUCCESS
    }
    fun failure() {
        message = FallbackMessageType.FAILURE
    }
    fun reset() {
        message = FallbackMessageType.FAILURE
    }
    fun isSucessful(): Boolean = message == FallbackMessageType.SUCCESS

    fun passTaskResult(taskResult: TaskResult) {
        if (taskResult.success) {
            success()
        } else {
            failure()
        }
    }
}

enum class  FallbackMessageType {
    SUCCESS,
    FAILURE,
}