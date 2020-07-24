package net.nyrheim.eaglesight.carrierpidgeon.item

import net.nyrheim.eaglesight.carrierpidgeon.distance.Distance
import net.nyrheim.eaglesight.carrierpidgeon.roll.Roll

sealed class WeaponProperty(
    val name: String
)

data class Versatile(
    val twoHandedRoll: Roll
) : WeaponProperty("Versatile")

class TwoHanded : WeaponProperty("Two-handed")

class Thrown : WeaponProperty("Thrown")

data class Special(
    val description: String
) : WeaponProperty("Special")

class Reach : WeaponProperty("Reach")

data class Range(
    val normalRange: Distance,
    val longRange: Distance
) : WeaponProperty("Range")

class Loading : WeaponProperty("Loading")

class Light : WeaponProperty("Light")

class Heavy : WeaponProperty("Heavy")

class Finesse : WeaponProperty("Finesse")

class Ammunition : WeaponProperty("Ammunition")