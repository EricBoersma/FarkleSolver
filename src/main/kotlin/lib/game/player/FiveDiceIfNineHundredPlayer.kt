package lib.game.player

import lib.play.IPlay

class FiveDiceIfNineHundredPlayer : IPlayer {
    override val playerKey: String = "FiveIfNineHundred"
    override var gameScore: Int = 0

    override fun rollAgain(rollScore: Int, diceRemaining: Int, roundScore: Int): Boolean {
        if(rollScore >= 900) {
            return diceRemaining !in 1..5
        }
        return true
    }

    override fun choosePlayToUse(highestScoring: IPlay, highestDiceUsed: IPlay, highestPotential: IPlay): IPlay {
        return chooseHighestScoringPlay(highestScoring, highestDiceUsed, highestPotential)
    }
}