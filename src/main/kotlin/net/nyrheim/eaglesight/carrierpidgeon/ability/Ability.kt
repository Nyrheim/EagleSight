package net.nyrheim.eaglesight.carrierpidgeon.ability

import com.google.gson.annotations.SerializedName
import java.util.*

enum class Ability(@SerializedName("name") val abilityName: String, val description: String, val abbreviation: String) {
    STRENGTH("Strength", "Measuring physical power", "STR"),
    DEXTERITY("Dexterity", "Measuring agility", "DEX"),
    CONSTITUTION("Constitution", "Measuring endurance", "CON"),
    INTELLIGENCE("Intelligence", "Measuring reasoning and memory", "INT"),
    WISDOM("Wisdom", "Measuring perception and insight", "WIS"),
    CHARISMA("Charisma", "Measuring force of personality", "CHA");

    companion object {
        fun getByAbbreviation(abbreviation: String?): Ability {
            return Arrays.stream(values())
                .filter { ability: Ability ->
                    ability.abbreviation.equals(abbreviation, ignoreCase = true)
                }.findFirst().orElse(null) as Ability
        }
    }

}