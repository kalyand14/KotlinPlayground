package app.extension

fun main() {

    //Extension methods
    val numbers = listOf(1, 2, 3, 4, 5)
    val alphabets = listOf('a', 'b', 'c')

    println(numbers.sumBy { it -> it })
    println(alphabets.sumBy { it -> it.toInt() })

    println(numbers.last())

    println(alphabets.subList(1, 3))

    for (s in alphabets) {
        println("${s}")
    }

    //HashMaps
    val errors = hashMapOf("00001" to "UI", "00002" to "View Model", "00003" to "UseCase", "00004" to "repository")

    val errorCode = "00004"
    println("The error occurred in ${errors[errorCode]}layer")

    val errorCode1 = "0"
    println("The error occurred in ${errors.getOrDefault(errorCode1, "Unknown place. try to debug")}layer")

    val errorCode2 = "9999"
    println("The error occurred in ${errors.getOrElse(errorCode2, {
        checkGW(errorCode2)
    })}")

    // Mutable Hash map


}

fun checkGW(errorCode: String): String {
    return "Gateway, ReachOut to testing/GW team for error $errorCode"
}

