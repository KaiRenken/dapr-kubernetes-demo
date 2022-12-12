package de.kairenken.daprkubernetesdemo.consumer

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {

    @PostMapping("/log")
    fun log(@RequestBody content: String): ResponseEntity<String> {

        println("Received message: '${content}' at Consumer-Pod: ${System.getenv("CONSUMER_POD_NAME")}")

        return ResponseEntity<String>("RECEIVED!!!", HttpStatus.OK)
    }
}