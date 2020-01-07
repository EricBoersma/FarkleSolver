package lib.roll

/**
 * A roll of the dice. Contains the number of dice rolled as well
 * as a hashmap representing the results of that roll.
 *
 * @property diceRolled: The number of dice rolled
 * @property rollResult: A hashmap indicating the results of the roll.
 */
class Roll(val diceRolled: Int, val rollResult: HashMap<Int, Int>) {}