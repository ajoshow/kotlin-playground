package com.ajoshow.kotlin.ex2

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {
    // if use withTimeout, we need to handle timeout exception ourselves

    val job = withTimeoutOrNull(100) {
        repeat(1000) {
            yield()
            print(".")
            Thread.sleep(1)
        }
    }

    if(job == null) {
        println("timeout")
    }

    delay(100)
    println("done")
}
