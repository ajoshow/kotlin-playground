package com.ajoshow.kotlin.ex1

fun main(args: Array<String>) {
    //
    // simple function
    //
    println(simpleHello())

    //
    // extension function
    //
    println("".extHello())

    //
    // lambda
    //
    println(lambdaTypeHello({ str -> "Hello" }))
    // above line can simplify to "it"
    println(lambdaTypeHello({ it }))
    // if lambda is at last parameter, we can move out of parentheses
    println(lambdaTypeHello { it })

    //
    // function literal
    //
    val funcLiteralHello: () -> String = fun() : String {
        return "Hello"
    }

    println(funcLiteralHello())

    //
    // function literal with receiver
    //
    var funcLiteralWithReceiverHello: String.(Int) -> String =  {
        input: Int -> this.toString() + input
    }
    println(funcLiteralWithReceiverHello("Hello", 1))

    funcLiteralWithReceiverHello = {
        toString() + it // omitted this, and input simplify to "it"
    }

    println(funcLiteralWithReceiverHello("Hello", 2))

    //
    // lambda with receiver, extension lambda
    //
    extLambdaHello("") {
        // return this.toString + "Hello"
        // "this" refers to receiver parameter
        this + "Hello"
    }
}

// simple function
fun simpleHello(): String {
    return "Hello"
}

// extension function
fun String.extHello() : String {
    // we can use this to get call-method class, in this case, String
    var value = this
    value = "Hello"
    return value
}

// https://www.slideshare.net/ssuser72c3b0/kotlin-receiver-types
// function with lambda type
fun lambdaTypeHello(supply: (String) -> String) : String {
    return supply("Hello")
}

// extension lambda, better known as lambda with receiver
fun extLambdaHello(receiver: String, block: String.()-> String) {
    val output = receiver.block()
    println(output)
}


