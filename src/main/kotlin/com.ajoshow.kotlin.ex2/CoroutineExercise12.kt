package com.ajoshow.kotlin.ex2

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {

    newSingleThreadContext("SingleThreadContext").use { ctx ->
        val job = GlobalScope.launch(CoroutineName("andy-context") + coroutineContext) {
            println("'SingleThreadContext' : In thread ${Thread.currentThread().name}")
        }
        job.join()
    }
}






