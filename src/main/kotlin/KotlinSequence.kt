import kotlin.random.Random

fun main(args: Array<String>) {
    val output = generateSequence {
        Random.nextInt()
    }.map {
        println("this line won't print if didn't call terminal function: $it")
        "oh my god $it"
    }.first()

    println(output)

    val output2 = generateSequence {
        Random.nextInt(5).takeIf { it > 0 }
    }.toList()

    println(output2)

    val output3 = sequence {
        var x = 0
        while(true) {
            x += 2
            yield(x)
        }
    }

    println(output3.take(10).toList())


    val output4 = sequence {
        println("andy")
        yield(5)
        println("andy2")
        yieldAll(6..8)
        println("andy3")
        yieldAll(listOf(9..10))
    }

    println(output4.take(2).toList())

    val output5 = sequence {
        println("yield one element")
        yield(1)
        println("yield a range")
        yieldAll(3..5)
        println("yield a list")
        yieldAll(listOf(7, 9))
    }

    println(output5
            .map { it * it }
            .filter { it > 10 }
            .take(1)
            .toList())
}