package lib.game.player

import lib.play.IPlay

interface IPlayer {
    val playerKey: String
    var gameScore: Int
    fun rollAgain(rollScore: Int, diceRemaining: Int, roundScore: Int): Boolean
    fun choosePlayToUse(highestScoring: IPlay, highestDiceUsed: IPlay, highestPotential: IPlay): IPlay
}