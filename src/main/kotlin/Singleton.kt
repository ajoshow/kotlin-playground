class Singleton{
    private constructor(){
        println("created")
    }

    companion object{
        val instance:Singleton by lazy { Singleton()}
        val create:Singleton by lazy { Singleton()}
    }
}

fun main(args:Array<String>){
    var v1 = Singleton.create
    var v4 = Singleton.create
    var v2 = Singleton.instance
    var v3 = Singleton.instance
}