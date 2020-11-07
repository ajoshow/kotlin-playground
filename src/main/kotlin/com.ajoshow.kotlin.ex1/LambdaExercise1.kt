package com.ajoshow.kotlin.ex1

fun main(args: Array<String>) {

    /* this is java
        BiFunction<Integer, Integer, Integer> sum = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer x, Integer y) {
                return x + y;
            }
        };
         OR
         BiFunction<Integer, Integer, Integer> sum = (x, y) -> x + y
    */

    // this is similar to javascript, var sum = function(x, y) {...}
    val sum: (Int, Int) -> Int = fun(x, y) : Int {
        return x + y
    }
    println(sum)
    println(sum(1, 2))

    val sum1: (Int, Int) -> Int = { x: Int, y:Int -> x + y}
    println(sum1)
    println(sum1(1, 2))

    // omit x, y type declare
    val sum2: (Int, Int) -> Int = { x, y -> x + y}
    println(sum2)
    println(sum2(1, 2))

    // omit sum3 type declare
    val sum3 = {x: Int, y:Int -> x + y}
    println(sum3)
    println(sum3(1, 2))

    // but can't omit both side type declaration, compile error as doesn't know x, y type.
    //val bad = {x, y -> x + y}
}
