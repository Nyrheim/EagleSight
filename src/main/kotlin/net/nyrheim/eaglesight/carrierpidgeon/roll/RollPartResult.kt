package net.nyrheim.eaglesight.carrierpidgeon.roll

import net.nyrheim.eaglesight.carrierpidgeon.roll.Roll.RollPart

class RollPartResult(private val rollPart: RollPart, results: List<Int>) {
    private val individualResults: List<Int> = results
    val result: Int

    override fun toString(): String {
        return "(" + individualResults.stream()
            .map(Int::toString)
            .reduce { a: String, b: String -> "$a+$b" }.orElse("Invalid roll.") as String + ")"
    }

    init {
        result = results.stream().reduce(
            0
        ) { i: Int, i1: Int -> Integer.sum(i, i1) } as Int
    }
}