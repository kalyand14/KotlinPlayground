package app

import java.util.*

fun main(args: Array<String>) {
    val t = readLine()!!.trim().toInt()
    val ds: DS = DS();
    for (i in 0 until t) {
        val op = readLine()!!
        when (op) {
            "i" -> println(ds.insert(readLine()!!.trim().toInt()))
            "d" -> println(ds.delete(readLine()!!.trim().toInt()))
            else -> println(ds.count)
        }
    }
}

class DS {

    val list: MutableList<Int> = mutableListOf()

    var count: Int = 0
        get() = list.size

    fun insert(value: Int): Int {

        //println("insert -> $value")

        list.add(value)

        return list.filter { it == value }.let { it.count() }
    }

    fun delete(value: Int): Int {

        //println("delete -> $value")

        val count = list.filter { it == value }.let { it.count() }

        if(count > 0)
            list.remove(value)

        return list.filter { it == value }.let { it.count() }

    }
}