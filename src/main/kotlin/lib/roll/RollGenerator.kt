package lib.roll

import kotlin.random.Random
import kotlin.random.nextInt

/**
 * Generates the value that landed "face up" on a single rolled die
 *
 * @return Int: The face value of the rolled die.
 */
fun generateDieValue(): Int {
    return Random.nextInt(1..6)
}

/**
 * Rolls the provided number of dice, then returns a new Roll object representing the result of the roll.
 *
 * @param diceRolled: The number of dice to roll
 *
 * @return Roll: The result of the roll.`
 */
fun generateRoll(diceRolled: Int): Roll {
    val rollResults = hashMapOf<Int, Int>(1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0)
    for (rollCount in 1..diceRolled) {
        val generatedRoll = generateDieValue()
        rollResults[generatedRoll] = rollResults[generatedRoll]!! + 1
    }
    return Roll(diceRolled, rollResults)
}