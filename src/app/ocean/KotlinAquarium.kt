package app.ocean

open class KotlinAquarium constructor(open var width: Int = 10, open var height: Int = 20, open var length: Int = 30) {
    // By having named parameter to the class default constructor there is no need to have constructor overloading similar to function.

    // Function also no need to overloaded as we can pass as needed and form all the combination

    // The below property can be define as private scope
    open var volume: Int
        get() = (width * height * length) / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open var shape: String = "Rectangle"

    open var water: Double = 0.0
        get() = volume * 0.90

    init {
        println("===Initializing KotlinAquarium====")
    }

    /* init {
         volume = (width * height * length) / 1000
     }*/

    constructor(numberOfFishes: Int) : this() {
        println("The number of fishes in this Aquarium would be $numberOfFishes")
        val tank = numberOfFishes * 2000 * 1.01
        height = (tank / (length * width)).toInt()
    }

    fun printSize() {
        println("This tank is $shape in shape")
        println("Width: ${width}cm Height: ${height}cm Length: ${length}cm")
        println("The volume of this Aquarium is ${volume}cubic cm Water: ${water}l (${water / volume * 100.0}%full)")
    }
}