package lib.util

import lib.game.player.AlwaysRollPlayer
import lib.play.scoring.RollScorer
import lib.play.scoring.scoringTree
import lib.roll.generateRoll
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

// Small function for re-calculating and displaying the average number of points scored per roll
@ExperimentalTime
fun main() {
    val rollScorer = RollScorer()
    val timeToExecute = measureTime {
        for (x in 1..6) {
            var totalScore = 0
            var totalRolls = 0
            while (totalRolls < 1000000) {
                totalRolls++
                val roll = generateRoll(x)
                totalScore += rollScorer.scoreRoll(roll, scoringTree, AlwaysRollPlayer())
            }
            val averageScore: Float = (totalScore.toFloat() / totalRolls)
            println("Number of dice: $x, average score: $averageScore")
        }
    }
    println("Time to execute ${timeToExecute.inSeconds}")
}
