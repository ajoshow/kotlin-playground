package com.ajoshow.kotlin.ex2

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) = runBlocking {
    val channel = Channel<Int>()

    val job = GlobalScope.launch {
        for(x in 1..5) {
            println("send $x")
            channel.send(x)
        }
    }

    println("receive: ${channel.receive()}")

    repeat(4) {
        println("receive: ${channel.receive()}")
    }

    job.join()

}








