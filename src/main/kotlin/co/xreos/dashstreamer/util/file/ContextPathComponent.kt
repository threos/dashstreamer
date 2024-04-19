package co.xreos.dashstreamer.util.file

import org.springframework.stereotype.Component
import java.io.File
import java.util.*


@Component
class ContextPathComponent {
    private final val contextPath: File = File("/tmp/dashstreamer/${UUID.randomUUID()}")

    init {
        contextPath.takeUnless { it.exists() }?.mkdirs()
    }

    fun getContextPath(): File {
        return contextPath
    }
}