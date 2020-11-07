package com.ajoshow.kotlin.ex2

import kotlinx.coroutines.*

fun main(args: Array<String>) = runBlocking {

    val outer = GlobalScope.launch {
        GlobalScope.launch(coroutineContext) {
            repeat(1000) {
                print(".")
                delay(1)
            }
        }
    }


    outer.join()
    println()
    println("Finished")

}

