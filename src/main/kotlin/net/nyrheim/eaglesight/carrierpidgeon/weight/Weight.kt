package net.nyrheim.eaglesight.carrierpidgeon.weight

import kotlin.math.roundToInt

class Weight(val value: Double, val unit: WeightUnit) : Comparable<Weight> {

    fun to(unit: WeightUnit): Weight {
        return Weight(
            value / this.unit.scaleFactor * unit.scaleFactor,
            unit
        )
    }

    operator fun times(amount: Int): Weight {
        return Weight(value * amount.toDouble(), unit)
    }

    override operator fun compareTo(other: Weight): Int {
        return (value / unit.scaleFactor - other.value / other.unit.scaleFactor).roundToInt()
    }

    override fun toString(): String {
        return if (value == value.toLong().toDouble()) java.lang.String.format(
            "%.0f%s",
            value,
            unit.name
        ) else java.lang.String.format("%s%s", value, unit.name)
    }

}