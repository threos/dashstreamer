package co.xreos.dashstreamer.util.fallback

import co.xreos.dashstreamer.util.camera.CameraStreamTaskSettings
import co.xreos.dashstreamer.util.fallback.base.IFallbackSettingsProvider

const val kMaxCameraIndex = 5

class CameraStreamTaskFallbackSettingsProvider : IFallbackSettingsProvider<CameraStreamTaskSettings> {
    override fun getMutatedSettingsOrNull(
        settings: CameraStreamTaskSettings,
        iterations: Int
    ): CameraStreamTaskSettings? {
        return (iterations + 1).takeIf {
            it <= kMaxCameraIndex
        }?.let {
            settings.copy(camera = it.toString())
        }
    }
}