package lib.util

import lib.game.Game
import lib.game.player.*
import org.nield.kotlinstatistics.geometricMean
import org.nield.kotlinstatistics.median
import org.nield.kotlinstatistics.standardDeviation
import java.text.DecimalFormat
import kotlin.time.ExperimentalTime

fun playPlayer(player: IPlayer) {
    var gamesPlayed = 0
    var totalRoundsPlayed = 0
    val listOfGamesPlayed: MutableList<Int> = mutableListOf()
    while (gamesPlayed < 10000) {
        gamesPlayed++
        val game = Game(player)
        player.gameScore = 0
        val roundsPlayed = game.playGame()
        totalRoundsPlayed += roundsPlayed
        listOfGamesPlayed.add(roundsPlayed)
    }
    val averageRoundsToWin = listOfGamesPlayed.geometricMean()
    val medianRoundsToWin = listOfGamesPlayed.median()
    val standardDeviation = listOfGamesPlayed.standardDeviation()
    val minimumRoundsToWin = listOfGamesPlayed.min()
    val maximumRoundsToWin = listOfGamesPlayed.max()
    val decimalFormat = DecimalFormat("##.##")
    println(
        "Player: ${player.playerKey}    |   Mean Rounds to 10K: ${decimalFormat.format(averageRoundsToWin)} |   Median Rounds to 10K: ${decimalFormat.format(
            medianRoundsToWin
        )}    |   StandardDeviation: ${decimalFormat.format(standardDeviation)}   |   Minimum Rounds: $minimumRoundsToWin |   Maximum Rounds: $maximumRoundsToWin"
    )
}

val players = listOf(
    HoldOnOneHundredPlayer(),
    HoldOnTwoHundredPlayer(),
    HoldOnThreeHundredPlayer(),
    HoldOnFourHundredPlayer(),
    HoldOnFiveHundredPlayer(),
    FiveHundredUnlessSixDicePlayer(),
    HoldOnSixHundredPlayer(),
    HoldOnSevenHundredPlayer(),
    HoldOnEightHundredPlayer(),
    HoldOnNineHundredPlayer(),
    HoldOnOneThousandPlayer(),
    ThreeHundredRoundPlayer(),
    FiveHundredRoundPlayer(),
    SevenHundredRoundPlayer(),
    FifteenHundredRoundPlayer(),
    TwoThousandRoundPlayer(),
    HoldOnFiveDicePlayer(),
    HoldOnFourDicePlayer(),
    HighestDiceUsedHoldFour(),
    HoldOnThreeDicePlayer(),
    HoldOnTwoDicePlayer(),
    HoldOnOneDiePlayer(),
    FourDiceIfFiveHundredPlayer(),
    TwoDiceIfFiveHundredPlayer(),
    ThreeDiceIfFiveHundredPlayer(),
    TwoHundredRoundPlayer(),
    ThreeDiceIfTwoHundredPlayer(),
    TwoDiceIfThreeHundredPlayer(),
    FourDiceIfSevenHundredPlayer(),
    FiveDiceIfNineHundredPlayer(),
    DecreasinglyAggressivePlayer(),
    IncreasinglyAggressivePlayer()
)

@ExperimentalTime
fun main() {
    for (player in players) {
        playPlayer(player)
    }
}