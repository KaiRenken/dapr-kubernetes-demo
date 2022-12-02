package de.kairenken

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ProducerApplication

fun main() {
    val client = HttpClient.newBuilder().build()

    val requestBody = "test-string"

    val request = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:8080/log"))
        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
        .build()

    while (true) {
        val response = client.send(request, HttpResponse.BodyHandlers.ofString());
        println(response.body())

        Thread.sleep(3000L)
    }
}