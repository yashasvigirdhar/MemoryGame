package `in`.yashasvi.memorygame.ui

import `in`.yashasvi.memorygame.models.CardData


interface OnCardClickedListener {
    fun onCardClicked(cardData: CardData)
}