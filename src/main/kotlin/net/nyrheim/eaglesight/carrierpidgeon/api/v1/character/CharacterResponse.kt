package net.nyrheim.eaglesight.carrierpidgeon.api.v1.character

import net.nyrheim.eaglesight.carrierpidgeon.PidgeonGson.auto
import net.nyrheim.eaglesight.carrierpidgeon.ability.Ability
import net.nyrheim.eaglesight.carrierpidgeon.character.PidgeonCharacter
import org.http4k.core.Body

data class CharacterResponse(
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
) {
    constructor(character: PidgeonCharacter) : this(
        character.id,
        character.playerId,
        character.name,
        character.height,
        character.weight,
        character.appearance,
        character.presence,
        character.age,
        character.experience,
        character.exhaustion,
        character.abilityScores,
        character.tempScores,
        character.abilityScoreChoices,
        character.firstClass,
        character.classes,
        character.race,
        character.hp,
        character.maxHp,
        character.tempHp
    )

    fun toCharacter() = PidgeonCharacter(
        id,
        playerId,
        name,
        height,
        weight,
        appearance,
        presence,
        age,
        experience,
        exhaustion,
        abilityScores,
        tempScores,
        abilityScoreChoices,
        firstClass,
        classes,
        race,
        hp,
        maxHp,
        tempHp
    )

    companion object {
        val lens = Body.auto<CharacterResponse>().toLens()
    }
}