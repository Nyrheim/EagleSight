package net.nyrheim.eaglesight.carrierpidgeon.race

import net.nyrheim.eaglesight.carrierpidgeon.ability.Ability
import net.nyrheim.eaglesight.carrierpidgeon.distance.Distance
import net.nyrheim.eaglesight.carrierpidgeon.item.ArmorType
import net.nyrheim.eaglesight.carrierpidgeon.item.WeaponType
import net.nyrheim.eaglesight.carrierpidgeon.skill.Skill
import net.nyrheim.eaglesight.carrierpidgeon.weight.Weight

data class BaseRace(
    override val name: String,
    override val aliases: List<String>,
    val abilityScoreModifiers: Map<Ability, Int>,
    override val minimumAge: Int,
    override val maximumAge: Int,
    override val speed: Distance,
    override val weaponProficiencies: List<WeaponType>,
    override val armorProficiencies: List<ArmorType>,
    override val minimumHeight: Distance,
    override val maximumHeight: Distance,
    override val minimumWeight: Weight,
    override val maximumWeight: Weight,
    override val darkVision: Distance,
    override val skillProficiencies: List<Skill>,
    override val traits: List<RaceTrait>
) : Race()