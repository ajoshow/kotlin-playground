package com.ajoshow.kotlin.ex2

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlin.random.Random
import kotlin.system.measureTimeMillis

data class Comment(var count: Int)

fun main(args: Array<String>) = runBlocking<Unit> {

    val discussion = Channel<Comment>()

    GlobalScope.launch(coroutineContext) { child("he did it", discussion) }
    GlobalScope.launch(coroutineContext) { child("she did it", discussion) }


    // start first comment
    discussion.send(Comment(0))
    delay(1000)
    coroutineContext.cancel()
}

suspend fun child(text:String, discussion: Channel<Comment>) {
    for(comment in discussion) {
        comment.count++
        println("$text $comment")
        delay(300)

        // continue next comment here
        discussion.send(comment)
    }
}








