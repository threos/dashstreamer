package co.xreos.dashstreamer.service

import org.apache.logging.log4j.LogManager.getLogger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.io.ByteArrayInputStream
import java.io.InputStream

@Service
class StreamFileService(
    @Autowired val contextPathIndex: ContextPathIndex,
) {
    private val logger = getLogger(javaClass)

    lateinit var thread: Thread

    init {
        logger.debug("Initialize stream file service")
    }

    fun getFile(name: String): ResponseEntity<ByteArrayInputStream> {
        return contextPathIndex.getFileOrNull(name)?.let {
            ResponseEntity.ok(ByteArrayInputStream(it.inputStream().readAllBytes()))
        } ?: ResponseEntity.notFound().build()
    }
}