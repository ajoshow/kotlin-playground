fun main(args:Array<String>){
    var max= if(1>2) 1 else 2
    print("max $max")

    var age = 30
    var isYoung = when(age){
        30 -> true
        else->false
    }
    println("isYoung: $isYoung")
}