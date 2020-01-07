package lib.game.player

import lib.play.IPlay

class HoldOnSevenHundredPlayer : IPlayer {
    override val playerKey: String = "HoldOnSevenHundred"
    override var gameScore: Int = 0

    override fun rollAgain(rollScore: Int, diceRemaining: Int, roundScore: Int): Boolean {
        return rollScore < 700
    }

    override fun choosePlayToUse(highestScoring: IPlay, highestDiceUsed: IPlay, highestPotential: IPlay): IPlay {
        return chooseHighestScoringPlay(highestScoring, highestDiceUsed, highestPotential)
    }
}