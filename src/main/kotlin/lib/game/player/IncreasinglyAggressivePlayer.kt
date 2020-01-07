package lib.game.player

import lib.play.IPlay

class IncreasinglyAggressivePlayer : IPlayer {
    override val playerKey: String = "IncreasinglyAggressive"
    override var gameScore: Int = 0

    override fun rollAgain(rollScore: Int, diceRemaining: Int, roundScore: Int): Boolean {
        if (gameScore < 2000) {
            return diceRemaining !in 1..5
        }
        return if (gameScore < 5000) {
            rollScore < 300
        } else {
            rollScore < 500
        }
    }

    override fun choosePlayToUse(highestScoring: IPlay, highestDiceUsed: IPlay, highestPotential: IPlay): IPlay {
        return chooseHighestScoringPlay(highestScoring, highestDiceUsed, highestPotential)
    }
}