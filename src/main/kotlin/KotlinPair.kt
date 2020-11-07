fun main(args: Array<String>) {
    println(Pair(1,2).toList())

    println(fibonacci().take(10).toList())
}

fun fibonacci() : Sequence<Int> {
    val output = sequence {
        var el = Pair(0, 1)
        while(true) { 
            yield(el.first)
            el = Pair(el.second, el.first + el.second)
        }
    }
    return output
}