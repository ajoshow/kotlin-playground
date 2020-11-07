fun main(args: Array<String>) {
    var sb = StringBuilder()

    sb.let {
        it.append("2")
    }

    sb.also { it.append(3) }


    sb.run {
        this.append(4)
    }

    sb.apply {
        this.append(5)
    }

    println(sb)


    var sb2 = StringBuilder()
    with(sb2) {
        append("hello")
        println(this)
    }

    var sb3 = StringBuilder()
    _with(sb3) {
        append("hello")
        println(this)
    }

    buildString {
        append("hh")
        println(this)
    }

    _buildString {
        append("hh")
        println(this)
    }
}

inline fun <T, R> _with( receiver: T, block: T.()-> R) : R {
    return receiver.block()
}

inline fun _buildString( act: StringBuilder.()->Unit) : String {
    val sb = StringBuilder();
    sb.act()
    return sb.toString()
}

inline fun <T, R> T._let(block: (T)->R) : R {
   return block(this)
}

inline fun <T, R> T._run (block: T.() -> R) : R {
    return block()
}

inline fun <T> T._also(block: (T)-> Unit) : T {
    block(this)
    return this
}

inline fun <T> T._apply(block: T.()-> Unit) : T {
    block()
    return this
}


