package co.xreos.dashstreamer.service

import co.xreos.dashstreamer.util.camera.CameraStreamTaskExecutor
import co.xreos.dashstreamer.util.camera.CameraStreamTaskSettings
import co.xreos.dashstreamer.util.file.ContextPathComponent
import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.apache.logging.log4j.LogManager.getLogger
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class CameraStreamService(
    val contextPathComponent: ContextPathComponent,
) {
    private val logger = getLogger(javaClass)

    lateinit var thread: Thread

    init {
        logger.debug("Initialize camera stream service")
    }

    @PostConstruct
    fun start() {
        logger.debug("Starting camera stream service")
        thread = Thread {
            logger.debug("Starting camera stream service thread")
            CameraStreamTaskExecutor(
                CameraStreamTaskSettings(
                    contextPath = contextPathComponent.getContextPath()
                ),
            ).execute()
        }
        thread.isDaemon = false
        thread.start()
    }

    @PreDestroy
    fun stop() {
        thread.interrupt()
    }

}