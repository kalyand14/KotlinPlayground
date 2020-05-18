import java.util.*

fun main() {

    val day = randomDay()
    val food = feedFish(day)
    println("Today is $day and fish eats $food \n")
    println("${if (changeWater(day, temperature = getTemperature())) "Its been while, Please change water" else "Neat and clean, No need to change water"}")
    filterImplementation()
    lazyfilterImplementation()
}

fun getDirtyReading(): Int = Random().nextInt(100)

fun getTemperature(): Int = Random().nextInt(100)

fun isHot(temperature: Int): Boolean = temperature > 30

fun isSunday(day: String): Boolean = day == "Sunday"

fun isDirty(reading: Int): Boolean = reading > 10

fun randomDay(): String {
    val dayList = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday")
    return dayList[Random().nextInt(dayList.size)]
}

fun feedFish(day: String): String {
    return when (day) {
        "Sunday" -> "Food A"
        "Monday" -> "Food B"
        "Tuesday" -> "Food C"
        "Wednesday" -> "Food D"
        "Thursday" -> "Food E"
        "Friday" -> "Food F"
        "Saturday" -> "Food G"
        else -> "Nothing"
    }
}

fun changeWater(day: String, temperature: Int = 20, reading: Int = getDirtyReading()): Boolean {

    println("Today's temperature is ${temperature}C\n")

    val message1 = if (isDirty(reading)) "dirty" else "clean"
    val message2 = if (isHot(temperature)) "but hot" else ""

    println("Water looks $message1 $message2")

    return when {
        isHot(temperature) -> true
        isDirty(reading) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun filterImplementation() {
    println("==== filterImplementation ===")

    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    println("The items in the decoration list are $decorations")

    val filterchar = 'p'
    val filtereditems = decorations.filter { it -> it.contains(filterchar) }

    println("The items that contain '$filterchar' are $filtereditems")
}

fun lazyfilterImplementation() {
    println("==== lazyfilterImplementation ===")

    val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
    println("The items in the decoration list are $decorations")

    val filterchar = 'p'
    val filtereditems = decorations.asSequence().filter { it.contains(filterchar) }

    println("The filter sequence is '$filterchar' are $filtereditems")
    println("The first filtered item '$filterchar' are ${filtereditems.first()}")

}