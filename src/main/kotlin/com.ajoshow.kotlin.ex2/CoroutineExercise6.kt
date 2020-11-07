package com.ajoshow.kotlin.ex2

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {

    val job = GlobalScope.launch {
        try {
            repeat(1000) {
                yield()
                print(".")
                Thread.sleep(10)
            }
        } catch (ex: CancellationException) {
            println()
            println("cancelled: ${ex.message}")
        } finally {
            withContext(NonCancellable) {
                println()
                println("in finally")
            }
        }
    }

    delay(100)
    job.cancel(CancellationException("too many jobs"))
    job.join()

    println("done")
}
