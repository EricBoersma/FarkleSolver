package lib.game.player

import lib.play.IPlay

class FiveHundredUnlessSixDicePlayer : IPlayer {
    override val playerKey: String = "HoldOnFiveHundredUnlessSix"
    override var gameScore: Int = 0

    override fun rollAgain(rollScore: Int, diceRemaining: Int, roundScore: Int): Boolean {
        if(diceRemaining == 6) {
            return true
        }
        return rollScore < 500
    }

    override fun choosePlayToUse(highestScoring: IPlay, highestDiceUsed: IPlay, highestPotential: IPlay): IPlay {
        return chooseHighestScoringPlay(highestScoring, highestDiceUsed, highestPotential)
    }
}