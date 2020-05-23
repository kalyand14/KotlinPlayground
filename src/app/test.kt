package app

import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.*
import kotlin.math.round

fun main(args: Array<String>) {
    var ip1: String = readLine()!!
    var ip2: String = readLine()!!
    var a: Any = ip1
    var b: Any = ip2
    if (ip1.toIntOrNull() != null) {
        a = ip1.toInt()
    } else if (ip1.toDoubleOrNull() != null) {
        a = ip1.toDouble()
    }

    if (ip2.toIntOrNull() != null) {
        b = ip2.toInt()
    } else if (ip2.toDoubleOrNull() != null) {
        b = ip2.toDouble()
    }
    val result = add(a, b)

    println(result)
}

fun <T : Any> add(a: T, b: T): T {
    return (
            when {
                a is Int && b is Int -> (a.toString().toInt() + b.toString().toInt()) as T
                a is Double || b is Double -> {
                    roundOffDecimal(a.toString().toDouble() + b.toString().toDouble()) as T
                }
                else -> ("$a $b") as T
            }
            )
}

fun roundOffDecimal(number: Double): Double {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.HALF_UP
    return df.format(number).toDouble()
}


//=================================

class Person {

    var firstName: String = ""
        set(value) {
            field = value
        }

    var lastName: String = ""
        set(value) {
            field = value
        }

    val fullName: String
        get() = "$firstName $lastName"

}
//=================================


operator fun String.div(b: String): String {

    val filterSet: MutableSet<Char> = mutableSetOf()
    for (char in this.toCharArray()) {
        if (char in b.toCharArray())
            filterSet.add(char)
    }
    return filterSet.joinToString("").trim()
}


//=================================

fun filter(list: MutableList<Int>): MutableList<Int> {
    val filterSet: MutableSet<Int> = mutableSetOf()
    for (item in list) {
        if (item % 2 != 0) {
            filterSet.add(item)
        }
    }
    return filterSet.toMutableList()
}

//=================================

fun minmax(nums: Array<Int>, findMinOrMax: (a: Int, b: Int) -> Boolean): Int {

    println("the array is ${Arrays.toString(nums)}")

    var minormax = nums[0]
    for (num in nums) {
        if (findMinOrMax(minormax, num))
            minormax = num
    }
    return minormax
}