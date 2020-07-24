package net.nyrheim.eaglesight.carrierpidgeon.distance

class DistanceUnit private constructor(val name: String, val scaleFactor: Double) {

    companion object {
        val FEET = DistanceUnit("ft", 50.0)
        val INCHES = DistanceUnit("in", 600.0)
        val METRES = DistanceUnit("m", 15.0)
        val CENTIMETRES = DistanceUnit("cm", 1500.0)
    }

}