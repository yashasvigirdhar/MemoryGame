package `in`.yashasvi.memorygame.ui.adapters

import `in`.yashasvi.memorygame.R
import `in`.yashasvi.memorygame.models.CardData
import `in`.yashasvi.memorygame.ui.OnCardClickedListener
import `in`.yashasvi.memorygame.ui.viewholders.CardsViewHolder
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class CardsAdapter(private var myDataset: List<CardData>, val context: Context, private val onCardClickedListener: OnCardClickedListener)
    : RecyclerView.Adapter<CardsViewHolder>() {


    override fun getItemCount(): Int {
        return myDataset.size;
    }

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        holder.bindModel(myDataset[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_card_collapsed_layout, parent, false)
        return CardsViewHolder(view, onCardClickedListener)
    }

    fun updateData(newDataSet: List<CardData>) {
        myDataset = newDataSet
    }

}