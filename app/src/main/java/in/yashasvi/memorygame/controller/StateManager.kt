package `in`.yashasvi.memorygame.controller

import `in`.yashasvi.memorygame.MemoryGameApplication
import `in`.yashasvi.memorygame.data.CardsRepository
import `in`.yashasvi.memorygame.models.CardData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StateManager @Inject constructor(var currentlyVisibleCard: CardData?,
                                       var currentLevel: Int,
                                       var numOfSolvedPairs: Int,
                                       private val cardsRepository: CardsRepository) {

    lateinit var gameStateChangeListener: GameStateChangeListener

    var isGameStarted = false;

    val timeLeft: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val currentCards: MutableLiveData<List<CardData>> by lazy {
        MutableLiveData<List<CardData>>()
    }

    init {
        currentLevel = 1;
        numOfSolvedPairs = 0;
        currentlyVisibleCard = null;
        currentCards.postValue(cardsRepository.getCardsForLevel(currentLevel))
        timeLeft.postValue(MemoryGameApplication.timeInSecondsToSolvePerLevel.get(currentLevel))

        // initially, set the state of all current cards to be visible
        // get visible duration of cards from rule engine based on level
        // and after countdown completes, update the states to hidden
        // expose this state, so that we don't honor touches.
    }

    fun onLevelCompleted() {
        currentLevel++
        currentCards.postValue(cardsRepository.getCardsForLevel(currentLevel))
    }

    fun onGameStarted() {
        // start countdown timer
        // keep updating timeLeft
        // and when countdown finished, call gameStateChangeListener.onGameOver
    }

}