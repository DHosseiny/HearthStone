package david.hosseini.hearthstone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_card.view.*

class CardsAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val cards = mutableListOf<Card>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_card, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount() = cards.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(cards[position])
    }


    fun setItems(newCards: List<Card>) {

        cards.clear()
        cards.addAll(newCards)
        notifyDataSetChanged()
    }

    fun clear() {

        cards.clear()
        notifyDataSetChanged()
    }
}


class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    fun bind(card: Card) {

        Glide
            .with(itemView.context)
            .load(card.img)
            .centerCrop()
            .placeholder(R.drawable.img_card_back)
            .into(itemView.image_card)

//        itemView.text_card_name.text = card.name
    }

}
