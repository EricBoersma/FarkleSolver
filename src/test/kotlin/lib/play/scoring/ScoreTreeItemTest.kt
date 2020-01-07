package lib.play.scoring

import lib.play.farkle
import lib.play.largeStraight
import lib.play.singleFive
import lib.play.singleOne
import lib.roll.Roll
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

val oneDiceFarkle = Roll(1, hashMapOf(1 to 0, 2 to 1, 3 to 0, 4 to 0, 5 to 0, 6 to 0))
val sixDiceStraight = Roll(6, hashMapOf(1 to 1, 2 to 1, 3 to 1, 4 to 1, 5 to 1, 6 to 1))
val singleScoringOne = Roll(3, hashMapOf(1 to 1, 2 to 2, 3 to 0, 4 to 0, 5 to 0, 6 to 0))
val singleScoringFive = Roll(3, hashMapOf(1 to 0, 2 to 2, 3 to 0, 4 to 0, 5 to 1, 6 to 0))

class ScoreTreeItemTest {
    // Matches Roll tests
    @Test
    fun `farkle matches any roll`() {
        val farklePlay = ScoreTreeItem(farkle, listOf())
        assertTrue(farklePlay.matchesRoll(oneDiceFarkle))
        assertTrue(farklePlay.matchesRoll(sixDiceStraight))
    }

    @Test
    fun `six dice straight only matches straight`() {
        val straightPlay = ScoreTreeItem(largeStraight, listOf())
        assertFalse(straightPlay.matchesRoll(oneDiceFarkle))
        assertTrue(straightPlay.matchesRoll(sixDiceStraight))
    }

    @Test
    fun `single one matches rolls with single ones`() {
        val singleOnePlay = ScoreTreeItem(singleOne, listOf())
        assertTrue(singleOnePlay.matchesRoll(sixDiceStraight))
        assertTrue(singleOnePlay.matchesRoll(singleScoringOne))
        assertFalse(singleOnePlay.matchesRoll(oneDiceFarkle))
    }

    @Test
    fun `single five matches rolls with single fives`() {
        val singleFivePlay = ScoreTreeItem(singleFive, listOf())
        assertTrue(singleFivePlay.matchesRoll(sixDiceStraight))
        assertTrue(singleFivePlay.matchesRoll(singleScoringFive))
        assertFalse(singleFivePlay.matchesRoll(oneDiceFarkle))
    }

    // Scoring Children Tests
    @Test
    fun `matching plays are returned from scoring children`() {
        val farklePlay =
            ScoreTreeItem(
                farkle,
                listOf(
                    ScoreTreeItem(singleOne, listOf()),
                    ScoreTreeItem(singleFive, listOf())
                )
            )
        val matchingScoringOne = farklePlay.scoringChildren(singleScoringOne)
        assertEquals(1, matchingScoringOne.count())
        assertEquals(singleOne, matchingScoringOne.first().play)

        val matchingScoringFive = farklePlay.scoringChildren(singleScoringFive)
        assertEquals(1, matchingScoringFive.count())
        assertEquals(singleFive, matchingScoringFive.first().play)
    }
}