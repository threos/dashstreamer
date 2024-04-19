package co.xreos.dashstreamer.util.fallback.execution

import co.xreos.dashstreamer.util.fallback.NoFallbackSettingsProvider
import co.xreos.dashstreamer.util.fallback.base.IFallbackSettingsProvider

object FallbackExecutor {
    fun <T: Any?, S> runWithFallback(initialSettings: S, fallbackSettingsProvider: IFallbackSettingsProvider<S>, function: (S, FallbackMessenger) -> T, parentMessenger: FallbackMessenger? = null): T? {
        val messenger = FallbackMessenger()
        var i = -1
        while (!Thread.interrupted()) {
            val settings = if (i == -1) initialSettings else (fallbackSettingsProvider.getMutatedSettingsOrNull(initialSettings, i) ?: return null)
            val result = function(settings, messenger)
            if (messenger.isSucessful()) {
                parentMessenger?.success()
                return result
            }
            if (result == null) {
                parentMessenger?.failure()
                return null
            }
            i++
            messenger.reset()
        }
        return null
    }
}