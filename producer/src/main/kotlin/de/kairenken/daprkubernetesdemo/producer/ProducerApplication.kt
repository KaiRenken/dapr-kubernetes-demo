package de.kairenken.daprkubernetesdemo.producer

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ProducerApplication

fun main(args: Array<String>) {
    val client = HttpClient.newBuilder().build()

    val requestBody = "Producer-Pod-Name: ${System.getenv("PRODUCER_POD_NAME")} | Request-Number: "

    var request: HttpRequest

    var counter = 1

    while (true) {
        request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:3500/log"))
            .header("dapr-app-id", "consumer-app")
            .POST(HttpRequest.BodyPublishers.ofString(requestBody + counter))
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        println(response.body() + " " + counter)

        Thread.sleep(3000L)

        counter++
    }
}