package co.xreos.dashstreamer.util.file

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.File
import java.util.*


@Component
class ContextPathComponent(
    @Value("\${dashstreamer.contextPathBase}") private val contextPathBase: String
){
    private final val contextPath: File = File("${contextPathBase}/${UUID.randomUUID()}")

    init {
        contextPath.takeUnless { it.exists() }?.mkdirs()
    }

    fun getContextPath(): File {
        return contextPath
    }
}