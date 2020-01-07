package lib.game.player

import lib.play.IPlay

class HoldOnFiveDicePlayer: IPlayer {
    override val playerKey: String = "HoldOnFive"
    override var gameScore: Int = 0

    override fun rollAgain(rollScore: Int, diceRemaining: Int, roundScore: Int): Boolean {
        return diceRemaining !in 1..5
    }

    override fun choosePlayToUse(highestScoring: IPlay, highestDiceUsed: IPlay, highestPotential: IPlay): IPlay {
        return chooseHighestScoringPlay(highestScoring, highestDiceUsed, highestPotential)
    }
}