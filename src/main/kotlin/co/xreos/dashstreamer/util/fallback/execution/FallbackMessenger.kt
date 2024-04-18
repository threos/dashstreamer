package co.xreos.dashstreamer.util.fallback.execution

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
}

enum class  FallbackMessageType {
    SUCCESS,
    FAILURE,
}