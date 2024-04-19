package co.xreos.dashstreamer.util.camera

import co.xreos.dashstreamer.util.fallback.NoFallbackSettingsProvider
import co.xreos.dashstreamer.util.fallback.base.IFallbackSettingsProvider
import co.xreos.dashstreamer.util.fallback.execution.FallbackExecutor
import co.xreos.dashstreamer.util.fallback.execution.FallbackMessenger
import co.xreos.ffexecutor.execution.FfmpegExecutor
import co.xreos.ffexecutor.task.FfmpegCommandTask
import java.io.File
import java.util.*

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
        FfmpegExecutor.run(
            FfmpegCommandTask(
                listOf(
                    "-f", CameraUtil.getPlatformCameraBackendAPIFormat(),
                    "-framerate", "30",
                    "-i", settings.camera,
                    "-b:v", "8M",
                    "-c:v", "libx264",
                    "-filter:v", "fps=30",
                    "-rtbufsize", "256M",
                    "-hls_master_name", "stream.m3u8",
                    "-hls_playlist", "1",
                    "-seg_duration", "2",
                    "stream.mpd"
                )
            ),
           settings.contextPath
        ).run {
            if(success) {
                fallbackMessenger.success()
            } else {
                fallbackMessenger.failure()

            }
        }
    }
}

data class CameraStreamTaskSettings(
    val camera: String = "0",
    val contextPath: File,
)