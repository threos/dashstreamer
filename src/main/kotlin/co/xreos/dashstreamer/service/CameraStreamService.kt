package co.xreos.dashstreamer.service

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.springframework.stereotype.Service

@Service
class CameraStreamService {
    lateinit var thread: Thread
    @PostConstruct
    fun start() {
        thread = Thread {
            while (!Thread.interrupted()) {
                println("Camera stream is running")
                Thread.sleep(1000)
            }
        }
        thread.isDaemon = true
    }

    @PreDestroy
    fun stop() {
        thread.interrupt()
    }

}