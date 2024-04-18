package co.xreos.dashstreamer.util.fallback

import co.xreos.dashstreamer.util.camera.CameraStreamTaskSettings
import co.xreos.dashstreamer.util.fallback.base.IFallbackSettingsProvider
import org.slf4j.LoggerFactory.getLogger

class NoFallbackSettingsProvider<T: Any>: IFallbackSettingsProvider<T> {
    val logger = getLogger(this::class.java)
    override fun getMutatedSettingsOrNull(settings: T, iterations: Int): T? {
        logger.warn("Using NoFallbackSettingsProvider, no fallback settings available. Returning null.")
        return null
    }

}