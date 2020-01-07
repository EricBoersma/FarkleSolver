package lib.game.player

import lib.play.IPlay

class DecreasinglyAggressivePlayer : IPlayer {
    override val playerKey: String = "DecreasinglyAggressive"
    override var gameScore: Int = 0

    override fun rollAgain(rollScore: Int, diceRemaining: Int, roundScore: Int): Boolean {
        if (gameScore < 2000) {
            return diceRemaining !in 1..2
        }
        return if (gameScore < 5000) {
            rollScore < 500
        } else {
            rollScore < 300
        }
    }

    override fun choosePlayToUse(highestScoring: IPlay, highestDiceUsed: IPlay, highestPotential: IPlay): IPlay {
        return chooseHighestScoringPlay(highestScoring, highestDiceUsed, highestPotential)
    }
}