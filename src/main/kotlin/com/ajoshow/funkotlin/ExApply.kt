fun main(args: Array<String>) {
    // let it run this, it also apply this
    var list = mutableListOf<Int>(1,2,3)
    list.apply {
        for(i in 0 until this.size) {
            this[i] *= 10
        }
    }
    println(list);
}