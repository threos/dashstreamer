package co.xreos.dashstreamer.util.camera

import co.xreos.dashstreamer.util.fallback.NoFallbackSettingsProvider
import co.xreos.dashstreamer.util.fallback.base.IFallbackSettingsProvider
import co.xreos.dashstreamer.util.fallback.execution.FallbackExecutor
import co.xreos.dashstreamer.util.fallback.execution.FallbackMessenger
import co.xreos.ffexecutor.constant.FfmpegAudioCodec
import co.xreos.ffexecutor.constant.FfmpegVideoCodec
import co.xreos.ffexecutor.execution.FfmpegExecutor
import co.xreos.ffexecutor.option.*
import co.xreos.ffexecutor.option.builder.FfmpegStreamBuilder
import co.xreos.ffexecutor.task.FfmpegCommandTask
import java.io.File

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

    private val kCustomOptions = arrayOf(
        "-ac", "2",
        "-ar", "44100",
        "-rtbufsize", "32M",
        "-hls_master_name", "stream.m3u8",
        "-hls_playlist", "1",
        "-adaptation_sets", "id=0,streams=v id=1,streams=a",
        "-f", "dash", "stream.mpd"
    )

    private fun executeInternal(settings: CameraStreamTaskSettings, fallbackMessenger: FallbackMessenger) {
        FfmpegExecutor.run(
            FfmpegCommandTask(
                FfmpegBackendAPIOption(CameraUtil.getPlatformCameraBackendAPIFormat()),
                FfmpegFramerateOption(framerate = 30),
                FfmpegVideoSizeOption(width = 640, height = 480),
                FfmpegHWInputOption(camera = settings.camera, audio = null),
                FfmpegAudioCodecOption(codec = FfmpegAudioCodec.AAC),
                FfmpegAudioChannelNumberOption(channels = 2),
                FfmpegAudioBitrateOption(kBitPerSecond = 128),
                FfmpegCustomOption(option = "-map 0:v:0 -map 0:a:0 -map 0:v:0 -map 0:a:0"),
                FfmpegVideoCodecOption(codec = FfmpegVideoCodec.H264),
                FfmpegStreamBuilder(index = 0)
                    .withVideoBitrate(megaBitPerSecond = 1)
                    .withVideoScaleFilter(width = -2, height = 240)
                    .build(),
                FfmpegStreamBuilder(index = 1)
                    .withVideoBitrate(megaBitPerSecond = 3)
                    .build(),
                FfmpegSegmentDurationOption(duration = 2),
                *kCustomOptions,
            ),
           settings.contextPath
        ).run {
            fallbackMessenger.passTaskResult(this)
        }
    }
}

data class CameraStreamTaskSettings(
    val camera: String = "0",
    val contextPath: File,
)