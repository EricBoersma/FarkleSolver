package lib.game.player

import lib.play.IPlay

class HoldOnFourDicePlayer : IPlayer {
    override val playerKey: String = "HoldOnFour"
    override var gameScore: Int = 0

    override fun rollAgain(rollScore: Int, diceRemaining: Int, roundScore: Int): Boolean {
        return diceRemaining !in 1..4
    }

    override fun choosePlayToUse(highestScoring: IPlay, highestDiceUsed: IPlay, highestPotential: IPlay): IPlay {
        return chooseHighestScoringPlay(highestScoring, highestDiceUsed, highestPotential)
    }
}