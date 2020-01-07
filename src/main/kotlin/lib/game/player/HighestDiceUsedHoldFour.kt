package lib.game.player

import lib.play.IPlay

class HighestDiceUsedHoldFour : IPlayer {
    override val playerKey: String = "HighestDiceFour"
    override var gameScore: Int = 0

    override fun rollAgain(rollScore: Int, diceRemaining: Int, roundScore: Int): Boolean {
        if (diceRemaining in 1..4) return false
        return true
    }

    override fun choosePlayToUse(highestScoring: IPlay, highestDiceUsed: IPlay, highestPotential: IPlay): IPlay {
        return chooseHighestDiceUsedPlay(highestScoring, highestDiceUsed, highestPotential)
    }
}