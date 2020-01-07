package lib.game.player

import lib.play.IPlay

class HoldOnSixHundredPlayer : IPlayer {
    override val playerKey: String = "HoldOnSixHundred"
    override var gameScore: Int = 0

    override fun rollAgain(rollScore: Int, diceRemaining: Int, roundScore: Int): Boolean {
        return rollScore < 600
    }

    override fun choosePlayToUse(highestScoring: IPlay, highestDiceUsed: IPlay, highestPotential: IPlay): IPlay {
        return chooseHighestScoringPlay(highestScoring, highestDiceUsed, highestPotential)
    }
}