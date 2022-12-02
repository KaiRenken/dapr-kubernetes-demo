package de.kairenken.daprkubernetesdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DaprKubernetesDemoApplication

fun main(args: Array<String>) {
    runApplication<DaprKubernetesDemoApplication>(*args)
}
