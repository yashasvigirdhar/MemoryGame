package `in`.yashasvi.memorygame.ui.viewmodel

import `in`.yashasvi.memorygame.MemoryGameApplication
import `in`.yashasvi.memorygame.controller.RuleEngine
import `in`.yashasvi.memorygame.controller.StateManager
import `in`.yashasvi.memorygame.models.CardData
import `in`.yashasvi.memorygame.models.CardState
import android.app.Application
import androidx.lifecycle.AndroidViewModel


class CardsViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var stateManager: StateManager
    private lateinit var ruleEngine: RuleEngine

    init {
        MemoryGameApplication.getInstance(application).applicationComponent().inject(this)
    }

    fun onCardClicked(cardData: CardData) {
        if (cardData.cardState == CardState.SOLVED) {
            // do nothing
        } else if (cardData.cardState.equals(CardState.VISIBLE)) {
            // card is open already but not solved. close it.
            cardData.cardState = CardState.HIDDEN
        } else if (cardData.cardState == CardState.HIDDEN) {
            cardData.cardState = CardState.VISIBLE

            if (stateManager.currentlyVisibleCard == null) {
                // this is the first card to be opened
            } else {
                // check if match happened
                val currentlyVisibleCard = stateManager.currentlyVisibleCard!!
                if (ruleEngine.areCardsEqual(currentlyVisibleCard, cardData)) {
                    // mark both as solved
                    cardData.cardState = CardState.SOLVED
                    currentlyVisibleCard.cardState = CardState.SOLVED
                    // check if game completed
                    if (ruleEngine.isGameCompleted()) {
                        stateManager.onLevelCompleted()
                    }
                } else {
                    // close both the cards
                    cardData.cardState = CardState.HIDDEN
                    currentlyVisibleCard.cardState = CardState.HIDDEN
                }

            }
        }
    }


}