open class Car{


    constructor(type:String, model:Int, price:Double, milesDrive:Int, owner:String):this(){
        println("type:$type")
        println("model:$model")
        println("price:$price")
        println("milesDrive:$milesDrive")
        println("owner:$owner")
    }

    constructor(){
        println("new")
    }

    open fun hi():String{
        return "hi"
    }


}

class CarChild:Car(){
    override fun hi():String{
        return "hi2"
    }
}

fun main(args:Array<String>){
    var huCar = Car("BMW", 2015, 1000.0, 105, "Andy")
    var huCar2 = Car()
    println(huCar.hi())
}