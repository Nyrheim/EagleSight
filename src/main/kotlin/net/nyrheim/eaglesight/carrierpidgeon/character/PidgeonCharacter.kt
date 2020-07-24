package net.nyrheim.eaglesight.carrierpidgeon.character

import net.nyrheim.eaglesight.carrierpidgeon.ability.Ability

data class PidgeonCharacter(
    val id: Int,
    val playerId: Int,
    val name: String,
    val height: String,
    val weight: String,
    val appearance: String,
    val presence: String,
    val age: Int,
    val experience: Int,
    val exhaustion: Int,
    val abilityScores: Map<Ability, Int>,
    val tempScores: Map<Ability, Int>,
    val abilityScoreChoices: Map<Ability, Int>,
    val firstClass: String?,
    val classes: Map<String, Int>,
    val race: String?,
    val hp: Int,
    val maxHp: Int,
    val tempHp: Int
)