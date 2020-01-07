package lib.game.player

import lib.play.IPlay

class FifteenHundredRoundPlayer : IPlayer {
    override val playerKey: String = "FifteenHundredRound"
    override var gameScore: Int = 0

    override fun rollAgain(rollScore: Int, diceRemaining: Int, roundScore: Int): Boolean {
        return roundScore < 1500
    }

    override fun choosePlayToUse(highestScoring: IPlay, highestDiceUsed: IPlay, highestPotential: IPlay): IPlay {
        return chooseHighestScoringPlay(highestScoring, highestDiceUsed, highestPotential)
    }
}