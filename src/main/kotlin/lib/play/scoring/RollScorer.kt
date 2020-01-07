package lib.play.scoring

import lib.game.player.IPlayer
import lib.play.IPlay
import lib.play.farkle
import lib.roll.Roll
import lib.roll.generateRollDiff

/**
 * A class used for scoring a roll. Includes options for scoring rolls based on the highest score,
 * the most dice used, and the highest potential score based on dice remaining.
 *
 * The final two options are rarely used, because they didn't wind up being as useful
 * as I'd initially anticipated. They're kept around as a historical insight into the code's development.
 */
class RollScorer {
    // Calculated using PerDiceScoreCalculator with a 335 point bump if your roll uses all the dice.
    val potentialMap = hashMapOf<Int, Int>(0 to 357, 1 to 136, 2 to 87, 3 to 105, 4 to 153, 5 to 220, 6 to 357)
    var highestScoringPlay: IPlay = farkle
    var highestDiceUsedPlay: IPlay = farkle
    var highestPotentialPlay: IPlay = farkle
    var diceRemovedByPlay: Int = 0

    /**
     * Accepts an IPlay scoring play and processes it. Determines whether it should replace the existing
     * highest dice-used play, and does so when applicable.
     *
     * @param scoringPlay: The play chosen by analyze roll, to be compared to the highest dice used play
     *
     * Void.
     */
    private fun processHighestDiceUsed(scoringPlay: IPlay) {
        if (scoringPlay.diceRemoved > highestDiceUsedPlay.diceRemoved) {
            highestDiceUsedPlay = scoringPlay
        } else if (scoringPlay.diceRemoved == highestDiceUsedPlay.diceRemoved && scoringPlay.pointsScored < highestDiceUsedPlay.pointsScored) {
            highestDiceUsedPlay = scoringPlay
        }
    }

    /**
     * Accepts an IPlay scoring play and processes it. Determines whether it should replace the existing
     * highest scoring play, and does so when applicable.
     *
     * @param scoringPlay: The play chosen by analyze roll, to be compared to the highest dice scoring play
     *
     * Void.
     */
    private fun processHighestScoringPlay(scoringPlay: IPlay) {
        if (scoringPlay.pointsScored > highestScoringPlay.pointsScored) {
            highestScoringPlay = scoringPlay
        } else if (scoringPlay.pointsScored == highestScoringPlay.pointsScored && scoringPlay.diceRemoved > highestScoringPlay.diceRemoved) {
            highestScoringPlay = scoringPlay
        }
    }

    /**
     * Accepts an IPlay scoring play and processes it. Determines whether it should replace the existing
     * highest potential play, and does so when applicable.
     *
     * @param scoringPlay: The play chosen by analyze roll, to be compared to the highest dice potential play
     *
     * Void.
     */
    private fun processHighestPotentialPlay(roll: Roll, scoringPlay: IPlay) {
        if(potentialScoreFromPlay(roll, scoringPlay) > potentialScoreFromPlay(roll, highestPotentialPlay)) {
            highestPotentialPlay = scoringPlay
        }
    }

    /**
     * Accepts a Roll and an IPlay and determines how many dice would be remaining
     * after the play was applied.
     *
     * @param roll: The roll being analyzed
     * @param scoringPlay: The play being applied to the roll
     *
     * @return Int: the integer value of the potential score from the remaining dice
     */
    private fun potentialScoreFromPlay(roll: Roll, scoringPlay: IPlay): Int {
        val diceRemaining = roll.diceRolled - scoringPlay.diceRemoved
        return potentialMap[diceRemaining]!!
    }

    /**
     * Resets all scores for the current roll scoring opportunity to their farkle base.
     *
     * Void.
     */
    fun resetScores() {
        highestScoringPlay = farkle
        highestDiceUsedPlay = farkle
        highestPotentialPlay = farkle
    }

    /**
     * Analyzes a roll based on the provided Roll and ScoreTreeItem. Compares the roll and
     * item to see if they match. If they do, then processes the scoring play from that item
     * to see if it should replace any of the three pinnacle scoring plays.  Then, applies
     * the same process to any children of the roll.
     *
     * @param roll: The roll being analyzed
     * @param scoringTree: The tree of scoring tree items used to analyze the potential scores for this roll
     *
     * Void.
     */
    fun analyzeRoll(roll: Roll, scoringTree: ScoreTreeItem) {
        if (!scoringTree.matchesRoll(roll)) return
        val scoringPlay = scoringTree.play

        processHighestDiceUsed(scoringPlay)
        processHighestScoringPlay(scoringPlay)
        processHighestPotentialPlay(roll, scoringPlay)

        val scoringChildren = scoringTree.scoringChildren(roll)
        for (child in scoringChildren) {
            analyzeRoll(roll, child)
        }
    }

    /**
     * Scores a Roll. Accepts a Roll, a ScoreTree (represented by the root ScoreTreeItem)
     * and a IPlayer.
     *
     * Examines all applicable plays to find the highest scoring, highest dice used, and
     * highest potential plays. Then allows the player to choose which play to apply. After a
     * play is applied, removes the dice used by the play and adds the total points scored on the roll.
     * Returns the points scored by the roll.
     *
     * @param roll: The roll being scored
     * @param scoringTree: The tree containing all potential scoring plays used to score the roll
     * @param player: The IPlayer which made the roll
     *
     * @return Int: The score of the roll
     */
    fun scoreRoll(
        roll: Roll,
        scoringTree: ScoreTreeItem,
        player: IPlayer
    ): Int {
        var pointsScored = 0
        var currentRoll = roll
        while (true) {
            resetScores()
            analyzeRoll(currentRoll, scoringTree)
            if (highestScoringPlay.pointsScored == 0) break
            val chosenPlay = player.choosePlayToUse(highestScoringPlay, highestDiceUsedPlay, highestPotentialPlay)
            pointsScored += chosenPlay.pointsScored
            diceRemovedByPlay += chosenPlay.diceRemoved
            if (chosenPlay.diceRemoved == currentRoll.diceRolled) break
            currentRoll = generateRollDiff(roll, chosenPlay)
        }
        return pointsScored
    }
}