package lib.roll

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

fun validDiceRolled(rollResult: Roll): Boolean {
    val diceRollCount = rollResult.rollResult.values.sum()
    return diceRollCount == rollResult.diceRolled
}

class RollGeneratorTest {
    @Test
    fun `generate dice value generates a valid value`() {
        val rollResult = generateDieValue()
        assertTrue(rollResult >= 1)
        assertTrue(rollResult <= 6)
    }

    @Test
    fun `generate roll generates a valid roll object`() {
        for (x in 1..6) {
            val generatedRoll = generateRoll(x)
            assertTrue(validDiceRolled(generatedRoll))
        }
    }
}
