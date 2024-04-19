package co.xreos.dashstreamer.service

import org.apache.logging.log4j.LogManager.getLogger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class StreamFileService(
    @Autowired val contextPathIndex: ContextPathIndex,
) {
    private val logger = getLogger(javaClass)

    init {
        logger.debug("Initialize stream file service")
    }

    fun getFile(name: String): ResponseEntity<ByteArray> {
        return contextPathIndex.getFileOrNull(name)?.let {
            ResponseEntity.ok(it.inputStream().readAllBytes())
        } ?: ResponseEntity.notFound().build()
    }
}