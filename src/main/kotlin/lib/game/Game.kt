package lib.game

import lib.game.player.IPlayer

/**
 * A test game of Farkle. Accepts only a single player. The goal here isn't
 * competition, but rather to determine how many rounds it takes the
 * provided player's logic to score 10,000 points
 *
 * @property player - The player playing this game
 */
class Game(val player: IPlayer) {
    private val winningScore = 10000

    /**
     * Plays a game of Farkle, recording the number of rounds until the player
     * playing this game scores 10,000 points.
     *
     * @return Int: The number of rounds this player took to score 10K points.
     */
    fun playGame(): Int {
        var roundsPlayed: Int = 0
        while (player.gameScore < winningScore) {
            val round = Round(player)
            round.playRound(player.gameScore, winningScore)
            roundsPlayed++
        }
        return roundsPlayed
    }
}