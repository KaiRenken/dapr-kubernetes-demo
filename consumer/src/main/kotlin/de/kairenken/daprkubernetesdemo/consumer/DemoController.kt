package de.kairenken.daprkubernetesdemo.consumer

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {

    var counter = 1

    @PostMapping("/log")
    fun log(@RequestBody content: String): ResponseEntity<String> {

        if (counter % 10 == 0) {
            counter++
            return ResponseEntity<String>("REJECTED!!!", HttpStatus.SERVICE_UNAVAILABLE)
        }

        println("Received message: '${content}' at Consumer-Pod: ${System.getenv("CONSUMER_POD_NAME")}")

        counter++
        return ResponseEntity<String>("RECEIVED!!!", HttpStatus.OK)
    }
}