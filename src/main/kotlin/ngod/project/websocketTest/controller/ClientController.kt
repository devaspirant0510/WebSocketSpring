package ngod.project.websocketTest.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ClientController {
    @GetMapping
    fun getPage():String{
        return "index.html"
    }
}