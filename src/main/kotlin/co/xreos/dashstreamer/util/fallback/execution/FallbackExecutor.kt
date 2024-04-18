package co.xreos.dashstreamer.util.fallback.execution

import co.xreos.dashstreamer.util.fallback.NoFallbackSettingsProvider
import co.xreos.dashstreamer.util.fallback.base.IFallbackSettingsProvider

object FallbackExecutor {
    fun <T: Any?, S> runWithFallback(initialSettings: S, fallbackSettingsProvider: IFallbackSettingsProvider<S>, function: (S, FallbackMessenger) -> T): T? {
        val messenger = FallbackMessenger()
        var i = 0
        while (true) {
            val result = function((fallbackSettingsProvider.getMutatedSettingsOrNull(initialSettings, i) ?: return null), messenger)
            if (messenger.isSucessful()) {
                return result
            }
            if (result == null) {
                return null
            }
            i++
            messenger.reset()
        }
    }
}