package study.com.finaltask

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ThankViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(thank: String) {
        val thankTextView: TextView = itemView.findViewById(R.id.thank_text_view)
        thankTextView.text = thank

    }
}