package net.nyrheim.eaglesight.carrierpidgeon.item

import net.nyrheim.eaglesight.carrierpidgeon.weight.Weight

sealed class ItemType {
    abstract val name: String
    abstract val displayName: String
    abstract val cost: Money
    abstract val weight: Weight
}

data class AdventuringGearType(
    override val name: String,
    override val displayName: String,
    override val cost: Money,
    override val weight: Weight
) : ItemType()

class ArmorType(
    override val name: String,
    override val displayName: String,
    val category: ArmorCategory,
    override val cost: Money,
    val armorClass: String?,
    val strengthRequirement: StrengthRequirement?,
    val disadvantageToStealthChecks: Boolean,
    override val weight: Weight,
    val isMetal: Boolean
) : ItemType()

data class WeaponType(
    override val name: String,
    override val displayName: String,
    val category: WeaponCategory,
    override val cost: Money,
    val damage: WeaponDamage?,
    override val weight: Weight,
    val properties: List<WeaponProperty>
) : ItemType()

data class GenericItemType(
    override val name: String,
    override val displayName: String,
    override val cost: Money,
    override val weight: Weight
) : ItemType()