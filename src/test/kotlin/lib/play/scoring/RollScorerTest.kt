package lib.play.scoring

import lib.game.player.AlwaysRollPlayer
import lib.roll.Roll
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import lib.util.hashMapWithMultipleValues


class RollScorerTest {
    // Score Tests
    @Test
    fun `large straight returns large straight as the primary scoring option`() {
        val roll = Roll(6, hashMapOf(1 to 1, 2 to 1, 3 to 1, 4 to 1, 5 to 1, 6 to 1))
        val scorer = RollScorer()
        scorer.analyzeRoll(roll, scoringTree)
        assertEquals(6, scorer.highestScoringPlay.diceRemoved)
        assertTrue(scorer.highestScoringPlay.scoringPlay)
        assertEquals(1000, scorer.highestScoringPlay.pointsScored)
    }

    @Test
    fun `triple ones returns triple ones as the highest scoring option`() {
        val roll = Roll(3, hashMapOf(1 to 3, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0))
        val scorer = RollScorer()
        scorer.analyzeRoll(roll, scoringTree)
        assertEquals(3, scorer.highestScoringPlay.diceRemoved)
        assertTrue(scorer.highestScoringPlay.scoringPlay)
        assertEquals(1000, scorer.highestScoringPlay.pointsScored)
    }

    @Test
    fun `three of a kind scores based on the value of the dice rolled`() {
        val scorer = RollScorer()
        for (x in 2..6) {
            val roll = Roll(3, hashMapWithMultipleValues(x, 3))
            scorer.analyzeRoll(roll, scoringTree)
            assertEquals(3, scorer.highestScoringPlay.diceRemoved)
            assertEquals(x * 100, scorer.highestScoringPlay.pointsScored)
            assertTrue(scorer.highestScoringPlay.scoringPlay)
            scorer.resetScores()
        }
    }

    @Test
    fun `three pairs scores 500`() {
        val scorer = RollScorer()
        var roll = Roll(6, hashMapOf(1 to 0, 2 to 0, 3 to 4, 4 to 2, 5 to 0, 6 to 0))
        scorer.analyzeRoll(roll, scoringTree)
        assertEquals(500, scorer.highestScoringPlay.pointsScored)
        assertEquals(6, scorer.highestScoringPlay.diceRemoved)

        roll = Roll(6, hashMapOf(1 to 0, 2 to 2, 3 to 2, 4 to 2, 5 to 0, 6 to 0))
        scorer.resetScores()
        scorer.analyzeRoll(roll, scoringTree)
        assertEquals(500, scorer.highestScoringPlay.pointsScored)
        assertEquals(6, scorer.highestScoringPlay.diceRemoved)
    }

    @Test
    fun `single one scores 100`() {
        val roll = Roll(6, hashMapOf(1 to 1, 2 to 1, 3 to 2, 4 to 2, 5 to 0, 6 to 0))
        val scorer = RollScorer()
        scorer.analyzeRoll(roll, scoringTree)
        assertEquals(100, scorer.highestScoringPlay.pointsScored)
        assertEquals(1, scorer.highestScoringPlay.diceRemoved)
    }

    @Test
    fun `double one scores 200`() {
        val roll = Roll(6, hashMapOf(1 to 2, 2 to 1, 3 to 0, 4 to 1, 5 to 0, 6 to 2))
        val scorer = RollScorer()
        scorer.analyzeRoll(roll, scoringTree)
        assertEquals(200, scorer.highestScoringPlay.pointsScored)
        assertEquals(2, scorer.highestScoringPlay.diceRemoved)
    }

    @Test
    fun `single five scores 50`() {
        val roll = Roll(6, hashMapOf(1 to 0, 2 to 1, 3 to 2, 4 to 2, 5 to 1, 6 to 0))
        val scorer = RollScorer()
        scorer.analyzeRoll(roll, scoringTree)
        assertEquals(50, scorer.highestScoringPlay.pointsScored)
        assertEquals(1, scorer.highestScoringPlay.diceRemoved)
    }

    @Test
    fun `double five scores 100`() {
        val roll = Roll(6, hashMapOf(1 to 0, 2 to 1, 3 to 0, 4 to 1, 5 to 2, 6 to 2))
        val scorer = RollScorer()
        scorer.analyzeRoll(roll, scoringTree)
        assertEquals(100, scorer.highestScoringPlay.pointsScored)
        assertEquals(2, scorer.highestScoringPlay.diceRemoved)
    }

    // highest dice used tests
    @Test
    fun `single one highest score and most used are the same`() {
        val roll = Roll(6, hashMapOf(1 to 1, 2 to 1, 3 to 2, 4 to 2, 5 to 0, 6 to 0))
        val scorer = RollScorer()
        scorer.analyzeRoll(roll, scoringTree)
        assertEquals(100, scorer.highestScoringPlay.pointsScored)
        assertEquals(1, scorer.highestScoringPlay.diceRemoved)
        assertEquals(100, scorer.highestDiceUsedPlay.pointsScored)
        assertEquals(1, scorer.highestDiceUsedPlay.diceRemoved)
    }

    @Test
    fun `double five highest score and most used are the same`() {
        val roll = Roll(6, hashMapOf(1 to 0, 2 to 1, 3 to 0, 4 to 1, 5 to 2, 6 to 2))
        val scorer = RollScorer()
        scorer.analyzeRoll(roll, scoringTree)
        assertEquals(100, scorer.highestScoringPlay.pointsScored)
        assertEquals(2, scorer.highestScoringPlay.diceRemoved)
        assertEquals(100, scorer.highestDiceUsedPlay.pointsScored)
        assertEquals(2, scorer.highestDiceUsedPlay.diceRemoved)
    }

    @Test
    fun `three pairs with ones are not highest scoring, but are highest dice used`() {
        val roll = Roll(6, hashMapOf(1 to 4, 2 to 2, 3 to 0, 4 to 0, 5 to 0, 6 to 0))
        val scorer = RollScorer()
        scorer.analyzeRoll(roll, scoringTree)
        assertEquals(1000, scorer.highestScoringPlay.pointsScored)
        assertEquals(3, scorer.highestScoringPlay.diceRemoved)
        assertEquals(500, scorer.highestDiceUsedPlay.pointsScored)
        assertEquals(6, scorer.highestDiceUsedPlay.diceRemoved)
    }

    // Full roll scoring tests
    @Test fun `large straight scores 1500`() {
        val roll = Roll(6, hashMapOf(1 to 1, 2 to 1, 3 to 1, 4 to 1, 5 to 1, 6 to 1))
        val scorer = RollScorer()
        val score = scorer.scoreRoll(roll, scoringTree, AlwaysRollPlayer())
        assertEquals(1000, score)
    }

    @Test fun `triple ones scores 1000`() {
        val roll = Roll(6, hashMapOf(1 to 3, 2 to 1, 3 to 1, 4 to 0, 5 to 0, 6 to 1))
        val scorer = RollScorer()
        val score = scorer.scoreRoll(roll, scoringTree, AlwaysRollPlayer())
        assertEquals(1000, score)
    }

    @Test fun `six ones scores 2000`() {
        val roll = Roll(6, hashMapOf(1 to 6, 2 to 0, 3 to 0, 4 to 0, 5 to 0, 6 to 0))
        val scorer = RollScorer()
        val score = scorer.scoreRoll(roll, scoringTree, AlwaysRollPlayer())
        assertEquals(2000, score)
    }

    @Test fun `two ones and a five scores 250`() {
        val roll = Roll(6, hashMapOf(1 to 2, 2 to 1, 3 to 1, 4 to 1, 5 to 1, 6 to 0))
        val scorer = RollScorer()
        val score = scorer.scoreRoll(roll, scoringTree, AlwaysRollPlayer())
        assertEquals(250, score)
    }
}