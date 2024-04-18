package co.xreos.dashstreamer.util.fallback

import co.xreos.dashstreamer.util.camera.CameraStreamTaskSettings
import co.xreos.dashstreamer.util.fallback.base.IFallbackSettingsProvider

class CameraStreamTaskFallbackSettingsProvider(
    val maxCameraIndex: Int = 5,
) : IFallbackSettingsProvider<CameraStreamTaskSettings> {
    override fun getMutatedSettingsOrNull(
        settings: CameraStreamTaskSettings,
        iterations: Int
    ): CameraStreamTaskSettings? {
        return (iterations + 1).takeIf {
            it <= maxCameraIndex
        }?.let {
            settings.copy(camera = it.toString())
        }
    }
}