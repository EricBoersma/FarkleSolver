package lib.game

import lib.game.player.IPlayer
import lib.play.scoring.RollScorer
import lib.play.scoring.scoringTree
import lib.roll.generateRoll

/**
 * A round in the game of Farkle. Represents a player, along with a scoring algorithm.
 * Rolls the dice, then attempts to find the best scoring play for the player. Once a play
 * has been registered, asks the player whether they'd like to roll again. If the player
 * chooses to roll again, the process starts over. If not, their score is recorded.
 *
 * @property player: The player playing this round.
 * @property scorer: The scoring algorithm used to score this play (defaults to new RollScorer instance)
 */
class Round(val player: IPlayer, private val scorer: RollScorer = RollScorer()) {
    fun playRound(currentGameScore: Int, winningScore: Int) {
        var roundScore = 0
        var currentDice = 6
        scorer.diceRemovedByPlay = 0
        while (true) {
            val newRoll = generateRoll(currentDice)
            val rollScore = scorer.scoreRoll(newRoll, scoringTree, player)
            roundScore += rollScore
            if (rollScore == 0) {
                break
            }
            currentDice -= scorer.diceRemovedByPlay
            scorer.diceRemovedByPlay = 0
            if (currentDice < 1) {
                currentDice = 6
            }
            if (currentGameScore + rollScore >= winningScore) {
                finishRound(rollScore)
                break
            }
            if (!player.rollAgain(rollScore, currentDice, roundScore)) {
                finishRound(roundScore)
                break
            }
        }
    }

    private fun finishRound(score: Int) {
        player.gameScore += score
        scorer.diceRemovedByPlay = 0
    }
}