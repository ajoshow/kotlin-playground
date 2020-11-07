package com.ajoshow.kotlin.ex2

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlin.system.measureTimeMillis

val numberOfWorkers = 10
val totalWork = 20

data class Work(var x: Long = 0, var y: Long = 0, var z: Long = 0)

suspend fun worker(input: Channel<Work>, output: Channel<Work>) {
    for (w in input) {
        w.z = w.x * w.y
        delay(w.z)
        output.send(w)
    }
}

fun run() {
    val input= Channel<Work>()
    val output= Channel<Work>()

    repeat(numberOfWorkers) {
        GlobalScope.launch {
            worker(input, output)
        }
    }

    GlobalScope.launch {
        sendLotsOfWork(input)
    }
    GlobalScope.launch {
        receiveLotsOfResults(output)
    }
}

suspend fun sendLotsOfWork(input: Channel<Work>) {
    repeat(totalWork) {
        input.send(Work((0L..100).random(), (0L..10).random()))
    }
}

suspend fun receiveLotsOfResults(channel: Channel<Work>) {
    for(work in channel) {
        println("${work.x} * ${work.y} = ${work.z}")
    }
}

fun main(args: Array<String>) = runBlocking<Unit> {

    run()
    runBlocking {  delay(5000) }
}

private object RandomRangerSingleton : java.util.Random()

fun ClosedRange<Long>.random() = (RandomRangerSingleton.nextInt((endInclusive.toInt() + 1) - start.toInt()) + start)








