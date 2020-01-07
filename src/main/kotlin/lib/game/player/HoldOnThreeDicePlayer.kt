package lib.game.player

import lib.play.IPlay

class HoldOnThreeDicePlayer : IPlayer {
    override val playerKey: String = "HoldOnThree"
    override var gameScore: Int = 0

    override fun rollAgain(rollScore: Int, diceRemaining: Int, roundScore: Int): Boolean {
        return diceRemaining !in 1..3
    }

    override fun choosePlayToUse(highestScoring: IPlay, highestDiceUsed: IPlay, highestPotential: IPlay): IPlay {
        return chooseHighestScoringPlay(highestScoring, highestDiceUsed, highestPotential)
    }
}