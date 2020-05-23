package app.collections

fun main() {

    val numbers = listOf(1, 2, 3, 4, 6, 10, 23, 53)
    val lambda: (Int) -> Boolean = { it < 10 }
    val lambda1: (Int) -> Int = { it * it }

    numbers.filter(lambda).forEach { println("$it") }

    numbers.filter(lambda).map(lambda1).forEach { println("$it") }

}

