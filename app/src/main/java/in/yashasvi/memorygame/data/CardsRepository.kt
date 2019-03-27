package `in`.yashasvi.memorygame.data

import `in`.yashasvi.memorygame.models.CardData
import `in`.yashasvi.memorygame.models.CardState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CardsRepository @Inject constructor() {

    private val cardsList: List<CardData> = listOf(CardData(1, "https://www.cambridgema.gov/~/media/Images/sharedphotos/departmentphotos/animal.jpg?mw=480", CardState.HIDDEN),
            CardData(2, "https://www.cambridgema.gov/~/media/Images/sharedphotos/departmentphotos/animal.jpg?mw=480", CardState.HIDDEN))


    fun getCardsForLevel(currentLevel: Int): List<CardData> {
        // right now, not considering level
        return cardsList
    }
}