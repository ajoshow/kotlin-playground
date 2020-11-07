package com.ajoshow.kotlin.ex2

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {
    val jobs = arrayListOf<Job>()

    createJobs(jobs)

    jobs.forEach { it.join() }

    println()
    println("================")
    println()

    val job = GlobalScope.launch {
        println("'launched Thread' : In thread ${Thread.currentThread().name}")
        val jobs = arrayListOf<Job>()
        createJobs(jobs)
        jobs.forEach { it.join() }
    }
    job.join()


}

// extension func
private fun CoroutineScope.createJobs(jobs: ArrayList<Job>) {
    jobs += GlobalScope.launch {
        println("'default' : In thread ${Thread.currentThread().name}")
    }

    // default is commonPool
    jobs += GlobalScope.launch(Dispatchers.Default) {
        println("'defaultDispatcher' : In thread ${Thread.currentThread().name}")
    }

    // the fork/join pool, which is the default pool in the current implementation,
    // this might be changed in the future.
//    jobs += GlobalScope.launch(CommonPool) {
//        println("'CommonPool' : In thread ${Thread.currentThread().name}")
//    }

    // starts the coroutine in the calling thread but only until the first
    // suspension point. Resumes on thread determined by the suspending function
    jobs += GlobalScope.launch(Dispatchers.Unconfined) {
        println("'Unconfined' : In thread ${Thread.currentThread().name}")
    }

    // inherit the ocntext of the current coroutine
    jobs += GlobalScope.launch(coroutineContext) {
        println("'coroutineContext' : In thread ${Thread.currentThread().name}")
    }

    // runs the coroutine on a new thread
    // this is an expensive operation
    // the new thread needs to be managed by your code
    jobs += GlobalScope.launch(newSingleThreadContext("OwnThread")) {
        println("'newSTC' : In thread ${Thread.currentThread().name}")
    }
}
