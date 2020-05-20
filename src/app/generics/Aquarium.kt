package app.generics

fun main() {

    val tapWaterCleaner: TapWaterCleaner = TapWaterCleaner()
    val lakeWaterCleaner: LakeWaterCleaner = LakeWaterCleaner()

    val lakeWaterAquarium: Aquarium<LakeWater> = Aquarium(LakeWater())
    lakeWaterAquarium.addWater(lakeWaterCleaner)

    val tapWaterAquarium: Aquarium<TapWater> = Aquarium(TapWater())
    tapWaterAquarium.addWater(tapWaterCleaner)

    // Without out keyword its not possible contravariant in kotlin - passing subtype to base type
    //val aquarium: Aquarium<WaterSupply> = tapWaterAquarium

    buyAquarium(lakeWaterAquarium)

}

open class WaterSupply(var needprocessing: Boolean)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needprocessing = false
        println("Filtering lake water using filter")
    }
}

class TapWater : WaterSupply(true) {
    fun treatWithChemicals() {
        needprocessing = false
        println("Treating tap water using chemicals")

    }
}

class FishStoreWater : WaterSupply(false)

interface Cleaner<in T : WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.treatWithChemicals()
    }

}

class LakeWaterCleaner : Cleaner<LakeWater> {
    override fun clean(waterSupply: LakeWater) {
        waterSupply.filter()
    }
}

data class Aquarium<T : WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if (waterSupply.needprocessing) {
            cleaner.clean(waterSupply)
        }
    }
}

fun <T : WaterSupply> buyAquarium(aquarium: Aquarium<T>) = println("Bought Aquarium -> $aquarium")

