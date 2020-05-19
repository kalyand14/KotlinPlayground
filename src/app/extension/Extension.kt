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

    val result1 = local_hasSpaces("Check this sentence contains space")
    println("normal function -> $result1")

    val result2 = "Check this sentence contains space".hasSpaces()
    println("extension function -> $result2")

    val view1 = View(12647).apply { visiblity = View.VISIBLE }
    view1.render()

    val view2 = View(12648).apply { visiblity = View.GONE }
    view2.render()

    val view3 = View(12649).apply { show() }
    view3.render()

    val view4 = View(12649).also { it.hide() }
    view4.render()

    // nullable receiver
    val view5: View? = null
    view5.show()
}


data class Fish(val name: String, val isFreshWater: Boolean)

fun local_hasSpaces(source: String): Boolean {
    return source.find { it == ' ' } != null
}

fun String.hasSpaces(): Boolean {
    return this.find { it == ' ' } != null
}

// With Null check
fun View?.show() {
    this?.apply {
        visiblity = View.VISIBLE
    }
}

fun View.hide() {
    this.visiblity = View.GONE
}

class View(val id: Int) {

    companion object {
        const val VISIBLE = 1
        const val GONE = 2
    }

    private var isShown: Boolean = false

    var visiblity: Int
        get() {
            return when {
                isShown -> VISIBLE
                else -> GONE
            }
        }
        set(value) {
            isShown = value == VISIBLE
        }

    fun render() {
        if (isShown)
            println("This object#${id} will be rendered")
    }
}