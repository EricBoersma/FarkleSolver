package lib.game.player

import lib.play.IPlay

class HoldOnOneDiePlayer : IPlayer {
    override val playerKey: String = "HoldOnOne"
    override var gameScore: Int = 0

    override fun rollAgain(rollScore: Int, diceRemaining: Int, roundScore: Int): Boolean {
        return diceRemaining != 1
    }

    override fun choosePlayToUse(highestScoring: IPlay, highestDiceUsed: IPlay, highestPotential: IPlay): IPlay {
        return chooseHighestScoringPlay(highestScoring, highestDiceUsed, highestPotential)
    }
}