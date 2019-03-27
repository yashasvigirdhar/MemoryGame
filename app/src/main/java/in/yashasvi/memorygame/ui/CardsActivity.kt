package `in`.yashasvi.memorygame.ui

import `in`.yashasvi.memorygame.MemoryGameApplication
import `in`.yashasvi.memorygame.R
import `in`.yashasvi.memorygame.controller.GameStateChangeListener
import `in`.yashasvi.memorygame.controller.ScoreManager
import `in`.yashasvi.memorygame.controller.StateManager
import `in`.yashasvi.memorygame.models.CardData
import `in`.yashasvi.memorygame.ui.adapters.CardsAdapter
import `in`.yashasvi.memorygame.ui.viewmodel.CardsViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_cards.*

class CardsActivity : AppCompatActivity(), OnCardClickedListener, GameStateChangeListener {

    private lateinit var layoutManager: GridLayoutManager
    private lateinit var cardsAdapter: CardsAdapter
    private lateinit var cardsViewModel: CardsViewModel
    private lateinit var stateManager: StateManager
    private lateinit var scoreManager: ScoreManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)
        supportActionBar?.title = getString(R.string.app_name)
        MemoryGameApplication.getInstance(this).applicationComponent().inject(this)
        cardsAdapter = CardsAdapter(emptyList(), this, this)

        layoutManager = GridLayoutManager(this, 2)
        cardsList.layoutManager = layoutManager
        cardsList.adapter = cardsAdapter

        cardsViewModel = ViewModelProviders.of(this).get(CardsViewModel::class.java)
        subscribeToData(stateManager.currentCards)
        stateManager.gameStateChangeListener = this

        stateManager.timeLeft.observe(this, Observer {
            // update ui based on time left
        })

    }

    override fun onCardClicked(cardData: CardData) {
        //open card
        cardsViewModel.onCardClicked(cardData)

    }

    private fun subscribeToData(cardsEntities: MutableLiveData<List<CardData>>) {
        cardsEntities.observe(this, Observer {
            cardsAdapter.updateData(it)
            cardsAdapter.notifyDataSetChanged()
            stateManager.onGameStarted()
        })
    }

    override fun onGameOver() {
        // show dialog to user that game is over
    }

    override fun onLevelChange(prevLevel: Int, curLevel: Int) {
        /**
         * 1. show success dialog with score. Get score from ScoreManager
         * 2. hide the dialog and show the next level. cards list would have been updated by stateManager
         */
    }

}
