package lib.play

interface IPlay {
    val scoringPlay: Boolean
    val pointsScored: Int
    val diceRequired: HashMap<Int, Int>
    val diceRemoved: Int
}

class Play(
    override val scoringPlay: Boolean,
    override val pointsScored: Int,
    override val diceRequired: HashMap<Int, Int>,
    override val diceRemoved: Int
) : IPlay {}