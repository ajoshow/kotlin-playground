package com.ajoshow.kotlin.ex1

fun main(args: Array<String>) {
    val a = Ex1_A(10)
    a.doubleValue()

    println("=======")

    val b = Ex1_B(10)
    b.doubleValue()

    println("=======")

    val c = Ex1_C(10)
    c.doubleValue()

    println("=======")

    val d1 = Ex1_D(10)
    d1.doubleValue()
    val d2 = Ex1_D(20, 30)
    d2.doubleValue()

}

interface Ex1_FunValue {
    // this value must be overridden at one of descenders
    val value: Int // every member under interface is implicitly 'open'

    fun doubleValue() {
        println("no value no fun");
    }
}

// class default is 'final', must explicit declare 'open'
open class Ex1_A(override val value: Int) : Ex1_FunValue {
    init{
        // surprise here !!
        println("com.ajoshow.kotlin.ex1.Ex1_A value: $value")
        /*
           public com.ajoshow.kotlin.ex1.Ex1_A(int value) {
             this.value = value;
             String var2 = "com.ajoshow.kotlin.ex1.Ex1_A value: " + this.getValue();
             boolean var3 = false;
             System.out.println(var2);
           }
        */
    }

    override fun doubleValue() {
        println( "com.ajoshow.kotlin.ex1.Ex1_A double value: ${value * 2}" )
    }
}

// with 'data', the compiler automatically derives equals, hashCode, toString, copy...
// 'data' cannot be inherit, so don't use inheritance with data classes.
data class Ex1_B(override val value: Int) : Ex1_A(value) {

    init{
        println("com.ajoshow.kotlin.ex1.Ex1_B value: $value")
    }

    override fun doubleValue() {
        println( "com.ajoshow.kotlin.ex1.Ex1_B double value: ${value * 2}" )
    }
}

class Ex1_C : Ex1_A {
    constructor(value: Int) : super(value)
}

class Ex1_D(override val value: Int) : Ex1_A(value) {
    constructor(value: Int, otherValue: Int) : this(value){
        println("com.ajoshow.kotlin.ex1.Ex1_D other value: $otherValue" )
    }
}
