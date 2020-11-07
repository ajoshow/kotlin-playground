package com.ajoshow.kotlin.ex2

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {

    val job = GlobalScope.launch {
       repeat(1000) {
//           if(!isActive)  throw CancellationException()
           if(!isActive) return@launch
//           yield()
           print(".")
           Thread.sleep(1)
       }
    }

    delay(100)
    job.cancelAndJoin()

    println("done")
}
