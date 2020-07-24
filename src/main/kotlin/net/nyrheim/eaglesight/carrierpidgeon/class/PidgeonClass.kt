package net.nyrheim.eaglesight.carrierpidgeon.`class`

import net.nyrheim.eaglesight.carrierpidgeon.ability.Ability
import net.nyrheim.eaglesight.carrierpidgeon.item.ArmorType
import net.nyrheim.eaglesight.carrierpidgeon.item.PidgeonItemStack
import net.nyrheim.eaglesight.carrierpidgeon.item.WeaponType
import net.nyrheim.eaglesight.carrierpidgeon.roll.Roll

class PidgeonClass(
    private val name: String? = null,
    private val description: String? = null,
    private val hitDie: Roll? = null,
    private val primaryAbility: Ability? = null,
    private val savingThrowProficiencies: List<Ability>? = null,
    private val armorProficiencies: List<ArmorType>? = null,
    private val weaponProficiencies: List<WeaponType>? = null,
    private val baseHP: Int = 0,
    private val levelHP: Int = 0,
    private val multiclassingRequirement: MulticlassingRequirement? = null,
    private val starterItems: List<PidgeonItemStack>? = null
)