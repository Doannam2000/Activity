package dd.wan.activityfragnav.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dd.wan.activityfragnav.R
import dd.wan.activityfragnav.model.color

class RecyclerAdapter1(var listItem: Array<String>,var color: color) : RecyclerView.Adapter<RecyclerAdapter1.ViewHolder>() {
    var itemSelected:Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter1.ViewHolder {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.listitem1, parent, false)
        return ViewHolder(view)
    }
    lateinit var itemClick: (position: Int) -> Unit
    fun setCallback(click: (position: Int) -> Unit) {
        itemClick = click
    }

    override fun onBindViewHolder(holder: RecyclerAdapter1.ViewHolder, position: Int) {
        holder.setData(listItem.get(position))
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView = itemView.findViewById(R.id.Item)
        fun setData(item: String) {
            textView.text = item
            if(adapterPosition == itemSelected)
            {
                textView.setTextColor(Color.parseColor(color.colorText1)) // "#ffffff"
                textView.setBackgroundColor(Color.parseColor(color.colorBackgroung1)) //#f21cc8"
            }
            else
            {
                textView.setTextColor(Color.parseColor(color.colorText2)) //222222
                textView.setBackgroundColor(Color.parseColor(color.colorBackgroung2)) // f8f8f8
            }
        }
        init {
            textView.setOnClickListener {
                itemSelected = adapterPosition
                notifyDataSetChanged()
//                itemClick.invoke(adapterPosition)
            }
        }
    }
}