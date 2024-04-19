package co.xreos.dashstreamer.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {

    @GetMapping("/")
    fun homePage(): String {
        return "home"
    }
}