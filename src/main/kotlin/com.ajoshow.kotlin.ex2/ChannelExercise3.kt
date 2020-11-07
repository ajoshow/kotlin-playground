package com.ajoshow.kotlin.ex2

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun productNumber() : Channel<Int> {
    val channel = Channel<Int>()

    GlobalScope.launch {
        for(x in 1..5) {
            println("send $x")
            channel.send(x)
        }
        channel.close()
    }

    return channel
}

fun productNumber2() : ReceiveChannel<Int> = GlobalScope.produce {
    for(x in 1..5) {
        println("send $x")
        channel.send(x)
    }
    println("done")
}

fun main(args: Array<String>) = runBlocking {
//    val channel = productNumber()
//
//    for(y in channel) {
//        println("receive: $y")
//    }

    val channel = productNumber2()

    channel.consumeEach {
        println(it)
    }

    println("main done")

}








