package co.xreos.dashstreamer.controller

import co.xreos.dashstreamer.service.StreamFileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.util.*

@RestController
@CrossOrigin(origins = ["*"], methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS])
@RequestMapping(value = ["/api/v1/file"])
class StreamFileController(
    @Autowired val streamFileService: StreamFileService,
) {
    @RequestMapping(value = ["/{name}"], method = [RequestMethod.GET], produces = [MediaType.APPLICATION_OCTET_STREAM_VALUE])
    fun getFile(
        @PathVariable name: String,
    ): ResponseEntity<ByteArray> = streamFileService.getFile(name)
}