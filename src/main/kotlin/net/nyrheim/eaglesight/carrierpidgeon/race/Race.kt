package net.nyrheim.eaglesight.carrierpidgeon.race

import net.nyrheim.eaglesight.carrierpidgeon.distance.Distance
import net.nyrheim.eaglesight.carrierpidgeon.item.ArmorType
import net.nyrheim.eaglesight.carrierpidgeon.item.WeaponType
import net.nyrheim.eaglesight.carrierpidgeon.skill.Skill
import net.nyrheim.eaglesight.carrierpidgeon.weight.Weight

abstract class Race {
    abstract val name: String
    abstract val aliases: List<String>
    abstract val minimumAge: Int
    abstract val maximumAge: Int
    abstract val speed: Distance
    abstract val weaponProficiencies: List<WeaponType>
    abstract val armorProficiencies: List<ArmorType>
    abstract val minimumHeight: Distance
    abstract val maximumHeight: Distance
    abstract val minimumWeight: Weight
    abstract val maximumWeight: Weight
    abstract val darkVision: Distance
    abstract val skillProficiencies: List<Skill>
    abstract val traits: List<RaceTrait>
}