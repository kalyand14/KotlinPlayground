package app.deco

fun main() {

    val object1 = Decoration("Gold")
    println(object1)

    val object2 = Decoration("Silver")
    println(object2)

    val object3 = Decoration("Silver")
    println(object3)

    val object4 = object3.copy("Silver")

    val object5 = object4

    println("checking object1 and object3 having equal value -> ${object1 == object3}")

    println("checking object2 and object3 having equal value -> ${object2 == object3}")

    println("checking object2 and object3 referring same object -> ${object2 === object3}")

    println("checking object3 and object4 having equal value -> ${object3 == object4}")

    println("checking object3 and object4 referring same object -> ${object3 === object4}")

    println("checking object4 and object5 referring same object -> ${object4 === object5}")

    println("The base url is ${Constants.BASE_URL}")

    println("Error -> title: ${Error.IO_ERROR.errorcode}, message:${Error.IO_ERROR.message}")

    println("Error -> title: ${Error.NETWORK_ERROR.errorcode}, message:${Error.NETWORK_ERROR.message}")

    println("The current stat is ${render(Loading())}")

    println("The current stat is ${render(Success())}")

    println("The current stat is ${render(Failure())}")

}

data class Decoration(var item: String)

object Constants {
    val BASE_URL: String = "https://www.hostname.com/port"
}

enum class Error(val errorcode: String, val message: String) {
    IO_ERROR("00002", "This is i/o error"), NETWORK_ERROR("00003", "This is network error")
}

fun render(state: State): String {
    return when (state) {
        is Loading -> "Loading"
        is Success -> "Success"
        is Failure -> "Failure"
    }
}

sealed class State
class Loading : State()
class Success : State()
class Failure : State()