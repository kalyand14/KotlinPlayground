package app.extension

fun main() {

    println(Constants.value_fixed_at_compiletime)

    println(MyFeatureConstants.value_fixed_at_compiletime)

    println(MyFeatureConstants().value_fixed_at_runtime)

}

class MyFeatureConstants {
    companion object {
        const val value_fixed_at_compiletime = "from inside the static block of a class"
    }

    val value_fixed_at_runtime = getStringValue()

    fun getStringValue(): String {
        return "Hello World"
    }

}

object Constants {
    const val value_fixed_at_compiletime = "From inside the singleton object"
}