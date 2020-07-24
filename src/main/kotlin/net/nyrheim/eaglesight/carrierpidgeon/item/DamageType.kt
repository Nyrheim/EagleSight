package net.nyrheim.eaglesight.carrierpidgeon.item

import com.google.gson.annotations.SerializedName

enum class DamageType(@SerializedName("name") val typeName: String) {
    ACID("Acid"),
    BLUDGEONING("Bludgeoning"),
    COLD("Cold"),
    FIRE("Fire"),
    FORCE("Force"),
    LIGHTNING("Lightning"),
    NECROTIC("Necrotic"),
    PIERCING("Piercing"),
    POISON("Poison"),
    PSYCHIC("Psychic"),
    RADIANT("Radiant"),
    SLASHING("Slashing"),
    THUNDER("Thunder");

}