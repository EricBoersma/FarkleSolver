package lib.play.scoring

import lib.play.*

private val scoreDoubleOne = ScoreTreeItem(
    doubleOne, listOf(
        ScoreTreeItem(pairsOneTwoThree),
        ScoreTreeItem(pairsOneTwoFour),
        ScoreTreeItem(pairsOneTwoFive),
        ScoreTreeItem(pairsOneTwoSix),
        ScoreTreeItem(pairsOneThreeFour),
        ScoreTreeItem(pairsOneThreeFive),
        ScoreTreeItem(pairsOneThreeSix),
        ScoreTreeItem(pairsOneFourFive),
        ScoreTreeItem(pairsOneFourSix),
        ScoreTreeItem(pairsOneFiveSix)
    )
)
private val scoreTripleFive = ScoreTreeItem(
    tripleFive, listOf(
        ScoreTreeItem(pairsFiveFour),
        ScoreTreeItem(pairsFiveSix),
        ScoreTreeItem(pairsFiveThree),
        ScoreTreeItem(pairsFiveTwo),
        ScoreTreeItem(pairsFiveOne)
    )
)
private val scoreDoubleFive = ScoreTreeItem(
    doubleFive,
    listOf(scoreTripleFive)
)
private val scoreTripleOne = ScoreTreeItem(
    tripleOne, listOf(
        ScoreTreeItem(pairsOneTwo),
        ScoreTreeItem(pairsOneThree),
        ScoreTreeItem(pairsOneFour),
        ScoreTreeItem(pairsOneFive),
        ScoreTreeItem(pairsOneSix)
    )
)
private val scoreTripleTwo = ScoreTreeItem(
    tripleTwo, listOf(
        ScoreTreeItem(pairsTwoOne),
        ScoreTreeItem(pairsTwoThree),
        ScoreTreeItem(pairsTwoFour),
        ScoreTreeItem(pairsTwoFive),
        ScoreTreeItem(pairsTwoSix)
    )
)
private val scoreTripleThree = ScoreTreeItem(
    tripleThree, listOf(
        ScoreTreeItem(pairsThreeOne),
        ScoreTreeItem(pairsThreeTwo),
        ScoreTreeItem(pairsThreeFour),
        ScoreTreeItem(pairsThreeFive),
        ScoreTreeItem(pairsThreeSix)
    )
)
private val scoreTripleFour = ScoreTreeItem(
    tripleFour, listOf(
        ScoreTreeItem(pairsFourOne),
        ScoreTreeItem(pairsFourTwo),
        ScoreTreeItem(pairsFourThree),
        ScoreTreeItem(pairsFourFive),
        ScoreTreeItem(pairsFourSix)
    )
)
private val scoreTripleSix = ScoreTreeItem(
    tripleSix, listOf(
        ScoreTreeItem(pairsSixOne),
        ScoreTreeItem(pairsSixTwo),
        ScoreTreeItem(pairsSixThree),
        ScoreTreeItem(pairsSixFour),
        ScoreTreeItem(pairsSixFive)
    )
)
private val scoreOne = ScoreTreeItem(
    singleOne,
    listOf(
        scoreDoubleOne,
        scoreTripleOne,
        ScoreTreeItem(largeStraight)
    )
)
private val scoreFive = ScoreTreeItem(
    singleFive, listOf(
        scoreDoubleFive,
        ScoreTreeItem(pairsTwoThreeFive),
        ScoreTreeItem(pairsTwoFourFive),
        ScoreTreeItem(pairsThreeFiveSix),
        ScoreTreeItem(pairsTwoFiveSix),
        ScoreTreeItem(pairsThreeFourFive)
    )
)

val scoringTree = ScoreTreeItem(
    farkle, listOf(
        scoreOne,
        scoreFive,
        scoreTripleTwo,
        scoreTripleThree,
        scoreTripleFour,
        scoreTripleSix,
        ScoreTreeItem(pairsTwoThreeFour),
        ScoreTreeItem(pairsTwoThreeSix),
        ScoreTreeItem(pairsTwoFourSix),
        ScoreTreeItem(pairsThreeFourSix)
    )
)