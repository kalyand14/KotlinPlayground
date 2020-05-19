package app.extension

fun main() {

    // Partition
    val fishList = arrayListOf(Fish("A", true), Fish("B", false), Fish("C", true), Fish("D", false))

    val filteredFish = fishList.partition { it -> it.isFreshWater }
    println("The fresh water list ${filteredFish.first}")
    println("The salter water list ${filteredFish.second}")

    // Pairs
    val fish_equipment = "net" to "fish"
    val sheep_equipment = "rope" to "sheep"
    println("${fish_equipment.second} is used to catch ${fish_equipment.first}")
    println("${sheep_equipment.second} is used to catch ${sheep_equipment.first}")

    // Triples
    val state = Triple("Loading", "Success", "Failure")
    println(state.first)
}


data class Fish(val name: String, val isFreshWater: Boolean)