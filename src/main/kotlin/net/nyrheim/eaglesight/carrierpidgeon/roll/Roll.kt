package net.nyrheim.eaglesight.carrierpidgeon.roll

import java.util.*
import java.util.regex.Pattern
import kotlin.math.sign

class Roll(private vararg val parts: RollPart) {
    fun roll(): List<RollPartResult> {
        return parts.map(RollPart::determine)
    }

    override fun toString(): String {
        val roll = parts
            .map { obj: RollPart -> obj.toString() }
            .fold(
                ""
            ) { a: String, b: String -> a + b }
        return if (roll.startsWith("+")) roll.substring(1) else roll
    }

    class Modifier(private val value: Int) :
        RollPart {
        override fun determine(): RollPartResult {
            return RollPartResult(this, mutableListOf(value))
        }

        override fun toString(): String {
            return value.toString()
        }

    }

    class Die @JvmOverloads constructor(private val rolls: Int, private val sides: Int, private val multiplier: Int = 1) :
        RollPart {
        private val random: Random = Random()
        override fun determine(): RollPartResult {
            val results = mutableListOf<Int>()
            for (i in 0 until rolls) {
                results.add(multiplier * (random.nextInt(sides) + 1))
            }
            return RollPartResult(this, results)
        }

        override fun toString(): String {
            return (if (sign(multiplier.toFloat()) == -1.0f) "-" else "+") + rolls + "d" + sides
        }

    }

    interface RollPart {
        fun determine(): RollPartResult
    }

    companion object {
        @Throws(NumberFormatException::class)
        fun parse(rollString: String): Roll {
            val parts = mutableListOf<RollPart>()
            val diePattern = Pattern.compile("[+\\-]\\d*d\\d+")
            val fullRollString = if (rollString.startsWith("+")) rollString else "+$rollString"
            val dieMatcher = diePattern.matcher(fullRollString)
            var rollStringWithoutDice: String
            while (dieMatcher.find()) {
                rollStringWithoutDice = dieMatcher.group()
                val multiplier = if (rollStringWithoutDice.startsWith("-")) -1 else 1
                val rollSections = rollStringWithoutDice.split("d").toTypedArray()
                val diceAmountString = rollSections[0].substring(1)
                val dieFaces = rollSections[1].toInt()
                val rollCount = if (diceAmountString.isEmpty()) 1 else diceAmountString.toInt()
                parts.add(
                    Die(
                        rollCount,
                        dieFaces,
                        multiplier
                    )
                )
            }
            rollStringWithoutDice = fullRollString.replace("[+\\-]\\d*d\\d+".toRegex(), "")
            val literalPattern = Pattern.compile("([+\\-]\\d+)(?!d)")
            val literalMatcher = literalPattern.matcher(rollStringWithoutDice)
            while (literalMatcher.find()) {
                val amount = literalMatcher.group(1).toInt()
                parts.add(Modifier(amount))
            }
            return Roll(*parts.toTypedArray())
        }
    }

}