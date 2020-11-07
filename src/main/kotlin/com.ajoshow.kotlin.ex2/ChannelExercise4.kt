package com.ajoshow.kotlin.ex2

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun productNumber3(): ReceiveChannel<Int> = GlobalScope.produce {
    var x = 1
    while (true) {
        send(x++)
    }
}


fun squareNumber(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = GlobalScope.produce {
    for(x in numbers) {
        send(x*x)
    }
}

fun main(args: Array<String>) = runBlocking<Unit> {

    val producer = productNumber3()
    val square = squareNumber(producer)

   for(i in 1..5) {
       println(square.receive())
   }

    println("main done")

    square.cancel()
    producer.cancel()

}








