package co.xreos.dashstreamer.util.fallback

interface IFallbackSettingsProvider<T> {
    fun getMutatedSettingsOrNull(settings: T, iterations: Int): T?
}