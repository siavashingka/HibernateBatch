package com.example.demo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

@Component
class Runner(private val service: SampleService) : CommandLineRunner {
    override fun run(vararg args: String?) {
        println("<<<<<<<<<<<<<< CREATE >>>>>>>>>>>>>>>>")
        service.create()
        println("<<<<<<<<<<<<<< TRANSACTIONAL CREATE >>>>>>>>>>>>>>>>")
        service.transactionalCreate()
        println("<<<<<<<<<<<<<< BATCH CREATE >>>>>>>>>>>>>>>>")
        service.batchCreate()
        println("<<<<<<<<<<<<<< TRANSACTIONAL BATCH CREATE >>>>>>>>>>>>>>>>")
        service.transactionalBatchCreate()
        println("<<<<<<<<<<<<<< CREATE AT ONCE >>>>>>>>>>>>>>>>")
        service.createAtOnce()
        println("<<<<<<<<<<<<<< TRANSACTIONAL CREATE AT ONCE >>>>>>>>>>>>>>>>")
        service.transactionalCreateAtOnce()
    }

}
