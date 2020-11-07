fun main(args:Array<String>){
    var x = 5
    when(x){
        1,2->print("value is 1 or 2")
        in 3..5->print("value is 3~5")
        !in 5..6->print("value is not in 5..6")
        else->print("value is else")
    }
}