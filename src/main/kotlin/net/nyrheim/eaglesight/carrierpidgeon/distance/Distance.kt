package net.nyrheim.eaglesight.carrierpidgeon.distance

import java.lang.String.format
import kotlin.math.roundToInt

class Distance(val value: Double, val unit: DistanceUnit) : Comparable<Distance> {

    fun to(unit: DistanceUnit): Distance {
        return Distance(value / this.unit.scaleFactor * unit.scaleFactor, unit)
    }

    override operator fun compareTo(other: Distance): Int {
        return (value / this.unit.scaleFactor - other.value / other.unit.scaleFactor).roundToInt()
    }

    override fun toString(): String {
        return if (value == value.toLong().toDouble()) format(
            "%.0f%s",
            value,
            unit.name
        ) else format("%s%s", value, unit.name)
    }

}