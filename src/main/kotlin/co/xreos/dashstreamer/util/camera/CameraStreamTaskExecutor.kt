package co.xreos.dashstreamer.util.camera

import co.xreos.dashstreamer.util.fallback.NoFallbackSettingsProvider
import co.xreos.dashstreamer.util.fallback.base.IFallbackSettingsProvider
import co.xreos.dashstreamer.util.fallback.execution.FallbackExecutor
import co.xreos.dashstreamer.util.fallback.execution.FallbackMessenger
import com.xreos.ffexecutor.context.FfmpegContext
import com.xreos.ffexecutor.execution.FfmpegExecutor

class CameraStreamTaskExecutor(
    private val initialSettings: CameraStreamTaskSettings,
    private val fallbackProvider: IFallbackSettingsProvider<CameraStreamTaskSettings> = NoFallbackSettingsProvider()
) {
    fun execute() {
        FallbackExecutor.runWithFallback(
            initialSettings,
            fallbackProvider,
            this::executeInternal
        )
    }

    fun executeInternal(settings: CameraStreamTaskSettings, fallbackMessenger: FallbackMessenger) {
        FfmpegExecutor.execute(
            FfmpegContext(

            ),
            fallbackMessenger
        )
    }
}

data class CameraStreamTaskSettings(
    val camera: String = "0",
    val context: String = "",
)