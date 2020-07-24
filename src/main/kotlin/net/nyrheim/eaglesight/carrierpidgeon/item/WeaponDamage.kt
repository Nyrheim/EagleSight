package net.nyrheim.eaglesight.carrierpidgeon.item

import net.nyrheim.eaglesight.carrierpidgeon.roll.Roll

data class WeaponDamage(
    val roll: Roll,
    val damageType: DamageType
)