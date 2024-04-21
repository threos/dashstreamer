package co.xreos.ffexecutor.constant

enum class FfmpegVideoCodec(val codec: String) {
    H264("libx264"),
    H265("libx265"),
    VP9("libvpx-vp9"),
    AV1("libaom-av1")
}