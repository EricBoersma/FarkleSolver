package lib.util

/**
 * Generates a new hash map with `multiple` dice of value `diceValue` set to rolled.
 *
 * @param diceValue: The face value of the die which should be rolled multiple times.
 * @param multiple: The number of dice which should be set to have rolled showing `diceValue`
 *
 * @return HashMap<Int, Int>: The roll results from after the roll
 */
fun hashMapWithMultipleValues(diceValue: Int, multiple: Int): HashMap<Int, Int> {
    val required = hashMapOf(1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0)
    return hashMapWithMultipleValues(diceValue, multiple, required)
}

/**
 * Modifies an existing roll result hash map to add multiples to an additional dice value.
 *
 * @param diceValue: The face value of the die which should be rolled multiple times.
 * @param multiple: The number of dice which should be set to have rolled showing `diceValue`
 * @param required: The existing hash map that should be modified
 *
 * @return HashMap<Int, Int>: The roll results from after the roll
 */
fun hashMapWithMultipleValues(diceValue: Int, multiple: Int, required: HashMap<Int, Int>): HashMap<Int, Int> {
    required[diceValue] = multiple
    return required
}