package com.ajoshow.kotlin.ex2

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {

    // get isActive inside the block
    val job = GlobalScope.launch {

        println("isActive? ${coroutineContext[Job]!!.isActive}")
    }

    // job.isActive
    job.join()

}

