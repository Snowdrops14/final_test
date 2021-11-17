package study.com.finaltask

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ThankAdapter(private val thankList: List<String>) : RecyclerView.Adapter<ThankViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThankViewHolder {

        val thankItemView =
            LayoutInflater.from(parent.context).inflate(R.layout.thank_list_item, parent, false)

        return ThankViewHolder(thankItemView)
    }

    override fun onBindViewHolder(holder: ThankViewHolder, position: Int) {
        val thank = thankList[position]
        holder.bind(thank)
    }

    override fun getItemCount(): Int {
        return thankList.size
    }
}