package co.xreos.dashstreamer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DashstreamerApplication

fun main(args: Array<String>) {
    runApplication<DashstreamerApplication>(*args)
}
