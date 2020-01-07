package lib.play.scoring

import lib.play.IPlay
import lib.roll.Roll

/**
 * A tree of possible scoring plays organized based on the dice used by each play.
 *
 * Represents an IPlay, which is the current play, as well as a list of IPlay children
 * which are plays that use a superset of the dice used by this IPlay.
 */
class ScoreTreeItem(val play: IPlay, private val children: List<ScoreTreeItem> = listOf()) {
    /**
     * Examines a Roll to determine whether it matches the IPlay used for this tree item.
     *
     * @return Boolean - Whether the roll matches
     */
    fun matchesRoll(roll: Roll): Boolean {
        if(play.diceRemoved > roll.diceRolled) return false

        for(x in 1..6) {
            if(roll.rollResult[x]!! < play.diceRequired[x]!!) return false
        }

        return true
    }

    /**
     * Examines the children of this item to determine whether any of their IPlay plays
     * match the provided Roll.
     *
     * @return List<ScoreTreeItem> - The list of matching children
     */
    fun scoringChildren(roll: Roll): List<ScoreTreeItem> {
        return children.filter { it.matchesRoll(roll) }
    }
}