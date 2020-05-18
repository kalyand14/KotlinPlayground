package app.ocean

fun buildAquarium() {
    val legacyaquarium: LegacyAquarium = LegacyAquarium()
    legacyaquarium.printAquarium()
    legacyaquarium.length = 100
    legacyaquarium.printAquarium()

    val kotlinAquarium: KotlinAquarium = KotlinAquarium()
    kotlinAquarium.printSize()
    kotlinAquarium.height = 100
    kotlinAquarium.printSize()

    val kotlinAquarium1: KotlinAquarium = KotlinAquarium(width = 100)
    kotlinAquarium1.printSize()

    val kotlinAquarium2 = KotlinAquarium(numberOfFishes = 10)
    kotlinAquarium2.printSize()

    val kotlinAquarium3 = KotlinAquarium(29)
    kotlinAquarium3.volume = 70
    kotlinAquarium3.printSize()

    val towerTank = TowerTank(height = 40, diameter = 25)
    towerTank.printSize()

    val shark = Shark()
    shark.printFish()
    shark.eat()
    shark.swim()
    shark.jump()
    shark.printFish()


    var smallFish = Plecostomus();
    smallFish.printFish()
    smallFish.eat()
    smallFish.swim()
    smallFish.jump()


}

class Shark : Fish("Big"), FishAction {
    override val color: String
        get() = "grey"

    override fun eat() {
        println("This hunt and eat other fishes")
    }

    override fun swim() {
        println("This swim deep in the ocean")
    }

    override fun jump() {
        println("This jump out the ocean and go in")
    }

}

class Plecostomus : Fish("Small"), FishAction {
    override val color: String
        get() = "gold"

    override fun eat() {
        println("This fish eats algae")
    }

    override fun swim() {
        println("This swim top of the ocean")
    }

    override fun jump() {
        println("This fish never jump")
    }
}

fun main() {
    buildAquarium()
}