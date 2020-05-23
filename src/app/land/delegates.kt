package app.land

fun main() {

    val snake = Snake()
    snake.showWhatYouGot()

    val parrot = Parrot()
    parrot.showWhatYouGot()

    val cattle = Cattle(object : CanMove {
        override fun move(): String {
            return "Walking slowly"
        }
    })
    cattle.showWhatYouGot()

    val homePageNavigator = HomePageNavigator()
    Controller(homePageNavigator).navigate()

}

interface Animals {
    fun showWhatYouGot()
}

object Carnivorous : CanEat {
    override fun eat(): String {
        return "Eat meat"
    }
}

object Herbivorous : CanEat {
    override fun eat(): String {
        return "Eat veggie"
    }
}

object Slither : CanMove {
    override fun move(): String {
        return "Slither"
    }
}

object Fly : CanMove {
    override fun move(): String {
        return "Fly"
    }

}

class Pet(val name: String) : LiveWhere {
    override fun live(): String {
        return "This animal can kept as pet. It lives in ${name}"
    }
}

object Forest : LiveWhere {
    override fun live(): String {
        return "This animal is dangerous. Live in forest"
    }
}

interface CanEat {
    fun eat(): String
}

interface LiveWhere {
    fun live(): String
}

interface CanMove {
    fun move(): String
}

class Snake : Animals, CanEat by Carnivorous, CanMove by Slither, LiveWhere by Forest {
    override fun showWhatYouGot() {
        println("===This is snake===")
        println("${live()}")
        println("Snake move by ${move()}")
        println("Snake eat ${eat()}")
    }
}

class Parrot : Animals, CanEat by Herbivorous, CanMove by Fly, LiveWhere by Pet("cage") {
    override fun showWhatYouGot() {
        println("===This is Parrot===")
        println("${live()}")
        println("Parrot move by ${move()}")
        println("Parrot ${eat()}")
    }
}

class Cattle(walk: CanMove) : Animals, CanEat by Herbivorous, CanMove by walk, LiveWhere by Pet("Shed") {
    override fun showWhatYouGot() {
        println("===This is Cattle===")
        println("${live()}")
        println("Cattle move by ${move()}")
        println("Cattle ${eat()}")
    }
}

interface Navigator {
    fun navigate()
}

class HomePageNavigator() : Navigator {
    override fun navigate() {
        println("Navigating to settings")
    }
}

class Controller(navigator: Navigator) : Navigator by navigator

val scope = CoroutineScope(Dispatchers.Main)

fun login() = scope.launch {
    view.showLoading()
    withContext(Dispatcher.IO) { networkClient.login(...) }
    view.hideLoading()
}

