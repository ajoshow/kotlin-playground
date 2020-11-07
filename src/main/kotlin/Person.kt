fun main(){
    println("andy".toUpperCase().also { println(it) })
    val p = Person("andy")
    val p2 = Person("bob", 10)
    println(p2.name)

    val s = Student("Cassie", 10)
    s.greeting()

    val a = Andy("super")
    a.name = "andy chu"
    println(a.name)
    a.sayHi()
    println(a.name)
}

open class Person(val name:String) {
    var age: Int = 0
    init{
        println("init")
    }
    constructor(name:String, age:Int): this(name) {
        this.age = age
    }

    open fun greeting() {
        println("my name is $name, and age is $age")
    }
}

class Teacher : Person {
    constructor(name: String) : super(name)
}

class Student(name: String) : Person(name) {
    constructor(name:String, age:Int) : this(name) {
        this.age = age
    }

    override fun greeting() {
        println("student name is $name, and age is $age")
    }
}

class Andy(val name2: String) {
    var name : String? = null
        get() = "$field!!"
        set(value) { field = value!!.toUpperCase()}
    fun sayHi() {
        println("hi ${this.name2}, $name")
    }
}