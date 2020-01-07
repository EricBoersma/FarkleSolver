package lib.roll

import lib.play.IPlay

/**
 * Accepts a Roll and an IPlay instance. Removes dice from the roll
 * based on the dice required by the IPlay. Returns a new roll
 * with the remaining dice, ready to be scored.
 *
 * @param roll: The roll that started this process
 * @param play: The play chosen for this roll
 *
 * @return Roll: The new roll containing the remaining dice after the play is applied.
 */
fun generateRollDiff(roll: Roll, play: IPlay): Roll {
    val newDiceRolled = roll.diceRolled - play.diceRemoved
    val rollResults = roll.rollResult
    for (x in 1..6) {
        rollResults[x] = rollResults[x]!! - play.diceRequired[x]!!
    }

    return Roll(newDiceRolled, rollResults)
}