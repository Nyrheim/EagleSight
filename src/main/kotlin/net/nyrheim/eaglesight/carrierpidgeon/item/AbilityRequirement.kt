package net.nyrheim.eaglesight.carrierpidgeon.item

import net.nyrheim.eaglesight.carrierpidgeon.ability.Ability

open class AbilityRequirement(val ability: Ability, val minimum: Int) {

    override fun toString(): String {
        return ">" + minimum + " " + ability.name
    }

}