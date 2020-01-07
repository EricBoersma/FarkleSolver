package lib.game.player

import lib.play.IPlay

class FourDiceIfFiveHundredPlayer : IPlayer {
    override val playerKey: String = "FourIfFiveHundred"
    override var gameScore: Int = 0

    override fun rollAgain(rollScore: Int, diceRemaining: Int, roundScore: Int): Boolean {
        if(rollScore >= 500) {
            return diceRemaining !in 1..4
        }
        return true
    }

    override fun choosePlayToUse(highestScoring: IPlay, highestDiceUsed: IPlay, highestPotential: IPlay): IPlay {
        return chooseHighestScoringPlay(highestScoring, highestDiceUsed, highestPotential)
    }
}