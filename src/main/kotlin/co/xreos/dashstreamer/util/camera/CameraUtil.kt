package co.xreos.dashstreamer.util.camera

object CameraUtil {
    fun getPlatformCameraBackendAPIFormat(): String {
        val osName = System.getProperty("os.name").lowercase()
        if(osName.contains("Windows")) {
            return "dshow"
        } else if (osName.contains("mac")) {
            return "avfoundation"
        } else if (osName.contains("nix") || osName.contains("nux")) {
            return "v4l2"
        }
        throw UnsupportedOperationException("CameraUtil does not support this operation system: $osName")
    }
}