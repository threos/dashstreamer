package co.xreos.dashstreamer.util.fallback.base

interface IFallbackSettingsProvider<T> {
    fun getMutatedSettingsOrNull(settings: T, iterations: Int): T?
}