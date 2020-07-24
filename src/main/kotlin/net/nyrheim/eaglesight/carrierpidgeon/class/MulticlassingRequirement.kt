package net.nyrheim.eaglesight.carrierpidgeon.`class`

import net.nyrheim.eaglesight.carrierpidgeon.ability.Ability

interface MulticlassingRequirement {
    class AbilityRequirement(private val ability: Ability, private val minimum: Int) : MulticlassingRequirement
    class AllRequirement(vararg val requirements: MulticlassingRequirement) : MulticlassingRequirement
    class AnyRequirement(vararg val requirements: MulticlassingRequirement) : MulticlassingRequirement
}