package com.ajoshow.kotlin.ex2

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {

    println("'runBlocking' : In thread ${Thread.currentThread().name}")


    val job = GlobalScope.launch(CoroutineName("andy-context") + coroutineContext) {
        println("'runBlocking' : In thread ${Thread.currentThread().name}")
    }
    job.join()
}

