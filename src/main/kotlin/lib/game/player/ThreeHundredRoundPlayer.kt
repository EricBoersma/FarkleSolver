package lib.game.player

import lib.play.IPlay

class ThreeHundredRoundPlayer : IPlayer {
    override val playerKey: String = "ThreeHundredRound"
    override var gameScore: Int = 0

    override fun rollAgain(rollScore: Int, diceRemaining: Int, roundScore: Int): Boolean {
        return roundScore < 300
    }

    override fun choosePlayToUse(highestScoring: IPlay, highestDiceUsed: IPlay, highestPotential: IPlay): IPlay {
        return chooseHighestScoringPlay(highestScoring, highestDiceUsed, highestPotential)
    }
}