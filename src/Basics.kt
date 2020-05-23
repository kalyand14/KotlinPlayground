import java.util.*
import kotlin.collections.ArrayList

fun main() {
    numericOperators()
    valandvars()
    numberConvertions()
    longNumberDeclarations()
    stringExpressions()
    ifUsingRange()
    ifAsExpression()
    whenStatement()
    whenExpression()
    whenconditions()
    nullvsNotNull()
    listandMutableList()
    arraysAreNonMutable()
    forLoops()
    whileLoops()
}

fun stringExpressions() {
    println("==== stringExpressions ===")

    val today = "Today is good"
    val tomorrow = "Tomorrow would be better"

    println("{$today --> $tomorrow}")

    val count: Int = 10
    println("i have $count fishes in the tank")

}

fun valandvars() {
    println("==== longNumberDeclarations ===")
    var change: String = "All is well"
    println("This is variable string. it current value is $change")
    change = "change is constant"
    println("This is variable string. it current value is $change")
    val constant = "Eventhing need to end one day"
    println("This is constant string. it current value is $constant")
    // uncomment me
    // constant = "you can change me untill i change on my own"
}

fun longNumberDeclarations() {
    println("==== longNumberDeclarations ===")
    val long: Long = 1_000_000
    println("This is long number $long")
    val hex = 0xFF_FF_FF_FF
    println("This is hex number $hex")
    val ssn = 999_99_9999L
    println("This is sss $ssn")
    val bytes = 0b111_11_11_11_11
    println("This is bytes $bytes")
}


fun numberConvertions() {

    println("==== numberConvertions ===")

    val i: Int = 10
    println("the value of i is $i")
    val string: String = i.toString()
    println("the value of i as string is $string")
    println("the value of i as byte is ${i.toByte()}")
    println("the value of i as double is ${i.toDouble()}")
    println("the value of i as float is ${i.toFloat()}")
    println("the value of i as char is ${i.toChar()}")
    println("the value of i as bigdecimal is ${i.toBigDecimal()}")
}

fun numericOperators() {

    println("==== numericOperators ===")

    // Integer
    val int: Int = 1
    val by: Int = 2

    val times = int.times(by)
    println("$int.times($by) = $times")

    val div = int.div(by)
    println("$int.div($by) = $div")

    val inc = int.inc()
    println("$int.inc() = $inc")

    val dec = int.dec()
    println("$int.dec() = $dec")

    val plus = int.plus(by)
    println("$int.plus($by) = $plus")

    val minus = int.minus(by)
    println("$int.minus($by) = $minus")
}

fun random(): Int {
    return Random().nextInt()
}

fun ifUsingRange() {
    println("==== ifUsingRange ===")
    val randomNumber: Int = random()
    if (randomNumber in 1..100) {
        println("You won a lottery")
    } else {
        println("Sorry you are not lucky")
    }
}

fun ifAsExpression() {
    println("==== ifAsExpression ===")
    val source = 100
    val result = if (source > 100) "you got enough" else "need more"
    println("the result is \"$result\"")
}

fun whenStatement() {
    println("==== whenStatement ===")
    val source: Int = 100

    println("The value of expression is $source")

    when {
        source > 100 -> println("This is more than 100")
        source <= 100 -> println("This is less than or equal to 100")
        else -> println("This is unknow")
    }
}

fun whenExpression() {
    println("==== whenExpression ===")
    val source: Int = 100
    val result = when {
        source > 100 -> "this is more than 100"
        source <= 100 -> "this is less than or equal to 100"
        else -> "this is unknown"
    }
    println(result)
}

fun whenconditions() {
    println("==== whenconditions ===")
    val source: Any = 100
    val result = when (source) {
        0 -> "This is equal to zero"
        in 1..100 -> "This is in range 1..100"
        !in 100..200 -> "This is not in range 100..200"
        is Int -> "this is Integer"
        else -> "this is unknown"
    }
    println(result)
}

fun nullvsNotNull() {
    println("==== nullvsNotNull ===")

    var index: Int
    index = 10
    println("The value of index is $index")
    // unComment me - to see erorr
    // index = null

    var nullable: Int? = null
    println("The value of nullable is $nullable")
    println("The value of nullable is ${nullable?.dec()}")
    println("The value of nullable is ${nullable?.dec() ?: 0}")
    nullable = 100
    println("The value of nullable is $nullable")
    println("The value of nullable is ${nullable.dec()}")
}

fun listandMutableList() {
    println("==== listandMutableList ===")

    val list = listOf("A", "B", "C", "D")
    println("The items in the non-mutable list are $list")

    // unComment me - to see erorr
    // list.remove("A ")

    val mutableList = mutableListOf("A", "B", "C", "D")
    println("The items in the mutable list are $mutableList")
    mutableList.add("E")
    println("The items in the mutable list are $mutableList")
    mutableList.remove("A")
    println("The items in the mutable list are $mutableList")
}

fun arraysAreNonMutable() {
    println("==== arraysAreNonMutable ===")

    val array = arrayOf("A", "B", "C", "D")
    println("The items in the array are $array")
    // unComment me - to see erorr
    // list.remove("A ")
    println("The items in the array are ${Arrays.toString(array)}")

    val dynamicInitialization = Array(5) { it * 5 }
    println("The items in the dynamicInitialization - array are ${Arrays.toString(dynamicInitialization)}")

    // Combining 2 int array
    val array1 = intArrayOf(1, 2, 3)
    val array2 = intArrayOf(4, 5, 6)
    val result = array1 + array2

    println("The operator overloading for array initialization array1 + array2 is  ${Arrays.toString(result)}")


}

operator fun String.div(filter:String) :String{
    val source = this.toCharArray()
    var result: ArrayList<Char> = ArrayList()
    for(char in source){
        if(char in filter.toCharArray())
        {
            result.add(char)
        }
    }

    if(result.size > 0)
        return  result.joinToString("").trim();
    else
        return ""
}

fun forLoops() {
    val fishes = arrayOf("FishA", "FishB", "FishB", "FishC")
    for (fish in fishes) {
        println("The fishes are - $fish")
    }

    for ((index, fish) in fishes.withIndex()) {
        println("$index - The fishes are - $fish")
    }

    for (index in 1..10) {
        println("The numbers in range are - $index")
    }

    for (index in 1..10 step 2) {
        println("The numbers in range by step are - $index")
    }

    for (index in 10 downTo 1 step 2) {
        println("The numbers 1 downto 10 are - $index")
    }

    for (index in 'a'..'g') {
        println("The characters between a..g are - $index")
    }
}

fun whileLoops() {
    var index = 5
    while (index++ in 1..10) {

        println("while loop - The numbers are - $index")
    }

    do {
        println("do while loop - The numbers are - $index")
    } while (index++ in 1..15)

    repeat(5){
        println("Repeating the statements - $it")
    }
}