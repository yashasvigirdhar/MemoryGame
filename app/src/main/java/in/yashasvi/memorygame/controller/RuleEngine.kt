package `in`.yashasvi.memorygame.controller

import `in`.yashasvi.memorygame.models.CardData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RuleEngine @Inject constructor() {

    val requiredPairsToSolvePerLevel = mapOf(
            1 to 3
    )

    val visibleDurationToLevel = mapOf(
            1 to 4
    )


    fun areCardsEqual(card1: CardData, card2: CardData): Boolean {
        return card1.imageUrl == card2.imageUrl
    }

    fun isGameCompleted(numOfSolvedPairs: Int, level: Int): Boolean {
        // check if solved no of pairs is equal to (m*n)/2
        return numOfSolvedPairs == requiredPairsToSolvePerLevel[level]
    }

    fun getIntialDurationForVisibleCards(level: Int): Int? {
        return visibleDurationToLevel[level]
    }
}