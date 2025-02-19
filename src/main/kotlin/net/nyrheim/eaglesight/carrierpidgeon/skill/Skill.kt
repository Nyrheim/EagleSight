package net.nyrheim.eaglesight.carrierpidgeon.skill

import com.google.gson.annotations.SerializedName
import net.nyrheim.eaglesight.carrierpidgeon.ability.Ability
import net.nyrheim.eaglesight.carrierpidgeon.ability.Ability.*

enum class Skill(@SerializedName("name") val skillName: String, val ability: Ability) {
    ATHLETICS("Athletics", STRENGTH),
    ACROBATICS("Acrobatics", DEXTERITY),
    SLEIGHT_OF_HAND("Sleight of Hand", DEXTERITY),
    STEALTH("Stealth", DEXTERITY),
    ARCANA("Arcana", INTELLIGENCE),
    HISTORY("History", INTELLIGENCE),
    INVESTIGATION("Investigation", INTELLIGENCE),
    NATURE("Nature", INTELLIGENCE),
    RELIGION("Religion", INTELLIGENCE),
    ANIMAL_HANDLING("Animal Handling", WISDOM),
    INSIGHT("Insight", WISDOM),
    MEDICINE("Medicine", WISDOM),
    PERCEPTION("Perception", WISDOM),
    SURVIVAL("Survival", WISDOM),
    DECEPTION("Deception", CHARISMA),
    INTIMIDATION("Intimidation", CHARISMA),
    PERFORMANCE("Performance", CHARISMA),
    PERSUASION("Persuasion", CHARISMA)

}