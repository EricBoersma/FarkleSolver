package lib.game.player

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

val fiveDicePlayer = HoldOnFiveDicePlayer()
val fourDicePlayer = HoldOnFourDicePlayer()
val threeDicePlayer = HoldOnThreeDicePlayer()
val twoDicePlayer = HoldOnTwoDicePlayer()
val oneDiePlayer = HoldOnOneDiePlayer()
val oneHundredPlayer = HoldOnOneHundredPlayer()
val twoHundredPlayer = HoldOnTwoHundredPlayer()
val threeHundredPlayer = HoldOnThreeHundredPlayer()
val fourHundredPlayer = HoldOnFourHundredPlayer()
val fiveHundredPlayer = HoldOnFiveHundredPlayer()
val sixHundredPlayer = HoldOnSixHundredPlayer()
val sevenHundredPlayer = HoldOnSevenHundredPlayer()
val eightHundredPlayer = HoldOnEightHundredPlayer()
val nineHundredPlayer = HoldOnNineHundredPlayer()
val oneThousandPlayer = HoldOnOneThousandPlayer()
val sevenHundredRoundScorePlayer = SevenHundredRoundPlayer()
val fifteenHundredRoundScorePlayer = FifteenHundredRoundPlayer()
val twoThousandRoundPlayer = TwoThousandRoundPlayer()
val alwaysRollPlayer = AlwaysRollPlayer()

class PlayerTest {
    @Test fun `dice count players roll again when they should`() {
        assertFalse(fiveDicePlayer.rollAgain(0, 5, 0))
        assertFalse(fiveDicePlayer.rollAgain(0, 1, 0))
        assertTrue(fiveDicePlayer.rollAgain(0, 6, 0))

        assertFalse(fourDicePlayer.rollAgain(0, 4, 0))
        assertTrue(fourDicePlayer.rollAgain(0, 5, 0))

        assertFalse(threeDicePlayer.rollAgain(0, 3, 0))
        assertTrue(threeDicePlayer.rollAgain(0, 4, 0))

        assertFalse(twoDicePlayer.rollAgain(0, 2, 0))
        assertTrue(twoDicePlayer.rollAgain(0, 3, 0))

        assertFalse(oneDiePlayer.rollAgain(0, 1, 0))
        assertTrue(oneDiePlayer.rollAgain(0, 2, 0))
    }

    @Test
    fun `roll count players roll when they should`() {
        assertFalse(oneHundredPlayer.rollAgain(100, 6, 0))
        assertFalse(oneHundredPlayer.rollAgain(200, 6, 0))
        assertTrue(oneHundredPlayer.rollAgain(50, 6, 0))

        assertTrue(twoHundredPlayer.rollAgain(100, 6, 0))
        assertFalse(twoHundredPlayer.rollAgain(200, 6, 0))
        assertFalse(twoHundredPlayer.rollAgain(250, 6, 0))

        assertTrue(threeHundredPlayer.rollAgain(250, 6, 0))
        assertFalse(threeHundredPlayer.rollAgain(300, 6, 0))

        assertTrue(fourHundredPlayer.rollAgain(350, 6, 0))
        assertFalse(fourHundredPlayer.rollAgain(400, 6, 0))

        assertTrue(fiveHundredPlayer.rollAgain(450, 6, 0))
        assertFalse(fiveHundredPlayer.rollAgain(500, 6, 0))

        assertTrue(sixHundredPlayer.rollAgain(550, 6, 0))
        assertFalse(sixHundredPlayer.rollAgain(600, 6, 0))

        assertTrue(sevenHundredPlayer.rollAgain(650, 6, 0))
        assertFalse(sevenHundredPlayer.rollAgain(700, 6, 0))

        assertTrue(eightHundredPlayer.rollAgain(750, 6, 0))
        assertFalse(eightHundredPlayer.rollAgain(800, 6, 0))

        assertTrue(nineHundredPlayer.rollAgain(850, 6, 0))
        assertFalse(nineHundredPlayer.rollAgain(900, 6, 0))

        assertTrue(oneThousandPlayer.rollAgain(950, 6, 0))
        assertFalse(oneThousandPlayer.rollAgain(1000, 6, 0))
    }

    @Test
    fun `round score players roll when they should`() {
        assertTrue(sevenHundredRoundScorePlayer.rollAgain(0, 6, 650))
        assertFalse(sevenHundredRoundScorePlayer.rollAgain(0, 6, 700))

        assertTrue(fifteenHundredRoundScorePlayer.rollAgain(0, 6, 1450))
        assertFalse(fifteenHundredRoundScorePlayer.rollAgain(0, 6, 1500))

        assertTrue(twoThousandRoundPlayer.rollAgain(0, 6, 1950))
        assertFalse(twoThousandRoundPlayer.rollAgain(0, 6, 2000))
    }
}