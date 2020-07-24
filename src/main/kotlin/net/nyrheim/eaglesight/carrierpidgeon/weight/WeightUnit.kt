package net.nyrheim.eaglesight.carrierpidgeon.weight

class WeightUnit private constructor(val name: String, val scaleFactor: Double) {

    companion object {
        val LB = WeightUnit("lb", 1.0)
        val OZ = WeightUnit("oz", 16.0)
    }

}