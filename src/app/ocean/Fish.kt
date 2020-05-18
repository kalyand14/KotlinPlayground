package app.ocean

abstract class Fish(val type: String) {
    abstract val color: String

    fun printFish() {
        println("This is $type fish and $color in color")
    }
}