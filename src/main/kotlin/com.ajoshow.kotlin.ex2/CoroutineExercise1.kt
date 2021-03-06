package com.ajoshow.kotlin.ex2

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicInteger

fun main(args: Array<String>) {

    val result = AtomicInteger()

//    for(i in 1..1_500_000) {
//        thread(start = true){
//            result.getAndIncrement()
//        }
//    }

    for(i in 1..1_500_000) {
        GlobalScope.launch {
            result.getAndIncrement()
        }
    }

    Thread.sleep(1000)
    println(result.get())

}

