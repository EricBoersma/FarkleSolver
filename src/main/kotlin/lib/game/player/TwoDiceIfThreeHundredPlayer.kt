package lib.game.player

import lib.play.IPlay

class TwoDiceIfThreeHundredPlayer : IPlayer {
    override val playerKey: String = "TwoIfThreeHundred"
    override var gameScore: Int = 0

    override fun rollAgain(rollScore: Int, diceRemaining: Int, roundScore: Int): Boolean {
        if(roundScore >= 300) {
            return diceRemaining !in 1..2
        }
        return true
    }

    override fun choosePlayToUse(highestScoring: IPlay, highestDiceUsed: IPlay, highestPotential: IPlay): IPlay {
        return chooseHighestScoringPlay(highestScoring, highestDiceUsed, highestPotential)
    }
}