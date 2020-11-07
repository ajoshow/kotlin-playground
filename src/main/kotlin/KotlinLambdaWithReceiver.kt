fun main(args: Array<String>) {
    var h = Human("andy", 10);

    // also, take lambda, return self
    // apply, take lambda with receiver, return self
    h = h.also {
        println("${it.name}")
        it.name = "andy2"
        println("${it.name}")
    }
    println("$h")
    println("=====")

    h = h.apply {
        println("$name")
        name = "andy3"
        println("${this.name}")
    }
    println("$h")
    println("=====")

    // let, take lambda, return result
    h = h.let {
        println("${it.name}")
        it.name = "andy4"
        println("${it.name}")
        Human("bob", 10)
    }
    println("$h")
    println("=====")

    // run, take lambda with receiver, return result
    h = h.run {
        println("${this.name}")
        name = "bob2"
        println("${name}")
        Human("john", 20)
    }
    println("$h")
    println("=====")

    h.walk()
    h.action("fly")
    h.action { println(it) }
    h.drink()
    h.free { println("free ${this.name}") }
}

data class Human(var name: String, var age: Int) {
    // regular function
    fun walk() = println("walk")

    // regular lambda function
    val action: (String) -> Unit = { println(it) }
    fun action( block: (String) -> Unit) { block("action") }

    // lambda with receiver
    fun free( block: Human.() -> Unit) { block() }
}

// extend function
fun Human.drink() = println("drink")

