package net.nyrheim.eaglesight.carrierpidgeon.api.v1.character

import net.nyrheim.eaglesight.carrierpidgeon.PidgeonGson.auto
import net.nyrheim.eaglesight.carrierpidgeon.ability.Ability
import org.http4k.core.Body

data class CharacterPatchRequest(
    val name: String?,
    val height: String?,
    val weight: String?,
    val appearance: String?,
    val presence: String?,
    val age: Int?,
    val abilityScores: Map<Ability, Int>?,
    val `class`: String?,
    val race: String?
) {
    companion object {
        val lens = Body.auto<CharacterPatchRequest>().toLens()
    }
}