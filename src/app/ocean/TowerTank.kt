package app.ocean

import java.lang.Math.PI

class TowerTank constructor(override var height: Int, var diameter: Int) : KotlinAquarium(width = diameter, height = height, length = diameter) {

    override var volume: Int
        get() = (width / 2 * length / 2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width / 2 * length / 2)).toInt()
        }

    override var shape: String = "Cylinder"

    override var water: Double = 0.0
        get() = volume * 0.80

}