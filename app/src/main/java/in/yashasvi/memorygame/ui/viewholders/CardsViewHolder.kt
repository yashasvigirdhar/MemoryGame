package `in`.yashasvi.memorygame.ui.viewholders

import `in`.yashasvi.memorygame.R
import `in`.yashasvi.memorygame.models.CardData
import `in`.yashasvi.memorygame.models.CardState
import `in`.yashasvi.memorygame.ui.OnCardClickedListener
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class CardsViewHolder(itemView: View, private val onCardClickedListener: OnCardClickedListener) : RecyclerView.ViewHolder(itemView) {

    private val titleTv: TextView = itemView.findViewById(R.id.tvTitle)
    private val imageIv: ImageView = itemView.findViewById(R.id.ivImage)

    fun bindModel(cardData: CardData?) {

        if (CardState.HIDDEN == cardData?.cardState) {
            titleTv.visibility = VISIBLE
            imageIv.visibility = GONE
        } else {
            titleTv.visibility = GONE
            imageIv.visibility = VISIBLE
            Glide.with(itemView.context).load(cardData?.imageUrl).into(imageIv)

        }
        itemView.setOnClickListener { onCardClickedListener.onCardClicked(cardData as CardData) }
    }
}