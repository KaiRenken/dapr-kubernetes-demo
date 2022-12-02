package de.kairenken.daprkubernetesdemo

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class DemoCallerApplication

fun main() {
    val client = HttpClient.newBuilder().build()
    val requestBody = "test-content"

    val request = HttpRequest.newBuilder()
        .uri(URI.create("http://localhost:8080/log"))
        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
        .build()

    val response = client.send(request, HttpResponse.BodyHandlers.ofString())
    println(response.body())
}