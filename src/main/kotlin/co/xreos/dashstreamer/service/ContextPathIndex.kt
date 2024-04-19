package co.xreos.dashstreamer.service

import co.xreos.dashstreamer.util.file.ContextPathComponent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.io.File

const val kFileScannerDelayMillis: Long = 100

@Service
class ContextPathIndex(
    @Autowired val contextPathComponent: ContextPathComponent
) {
    var files: Map<String, File> = emptyMap()
    @Scheduled(fixedRate = kFileScannerDelayMillis)
    fun scheduleScanTask() {
        files = contextPathComponent.getContextPath().listFiles()?.mapNotNull {
            if(it.isDirectory) null
            else it.name to it
        }?.toMap() ?: throw IllegalStateException("Failed to list files in context path.")
    }

    fun getFileOrNull(name: String): File? {
        return files[name]
    }
}