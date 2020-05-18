fun main() {
    val dirty_level: Int = 56
    val threshold: Int = 10

    val lambda: (Int) -> Int = { reading -> (reading / threshold) * 100 }
    val isDirty = higherOrderFunction_single_param(dirty_level, lambda)
    println("passing lambda expression as last param -> $isDirty")

    val lambda1: (Int, Float) -> Float = { reading, correction -> (reading / threshold) * correction }
    val result1 = higherOrderFunction_multiple_param(dirty_level, lambda1)
    println("passing lambda expression with multiple parameter as last param -> $result1")

    val result2 = higherOrderFunction_multiple_param(dirty_level, ::normalFunction)
    println("passing normal function as param -> $result2")

    val result3 = higherOrderFunction_multiple_param(dirty_level, fun(reading: Int, correction: Float): Float { return (reading / threshold) * correction })
    println("passing anonymous function as param -> $result3")

}

fun higherOrderFunction_single_param(dirty_level: Int, sensor: (Int) -> Int): Boolean {
    println("=====Executing higherOrderFunction_single_param function=====")
    return dirty_level > sensor(dirty_level)
}

fun higherOrderFunction_multiple_param(dirty_level: Int, sensor: (Int, Float) -> Float): Boolean {
    println("=====Executing higherOrderFunction_multiple_param function====")
    val correction = 1.0f
    return dirty_level > sensor(dirty_level, correction)
}

fun normalFunction(reading: Int, correction: Float): Float {
    println("====Executing normal function====")
    return (reading / 10) * correction
}

