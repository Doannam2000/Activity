package dd.wan.activityfragnav.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import dd.wan.activityfragnav.R
import dd.wan.activityfragnav.model.Stock

class RecyclerAdapterStock(var list: ArrayList<Stock>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        var view: View
        if (viewType == 1) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.footer, parent, false)
            return FooterViewHolder(view)
        } else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.liststock, parent, false)
            return ViewHolder(view)
        }
    }

    lateinit var itemClick : (position:Int)->Unit

    fun setCallBack(click:(position:Int)->Unit)
    {
        itemClick = click
    }

    override fun getItemViewType(position: Int): Int {
        if (position == list.size) {

            return 1
        } else {

            return 2
        }
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.setData(list.get(position))
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.name)
        var location: TextView = itemView.findViewById(R.id.location)
        var time: TextView = itemView.findViewById(R.id.time)
        var rate: TextView = itemView.findViewById(R.id.rate)
        var percent: TextView = itemView.findViewById(R.id.percent)
        var constraint:ConstraintLayout = itemView.findViewById(R.id.constraintStock)
        fun setData(item:Stock)
        {
            name.text = item.name
            location.text = item.location
            time.text = item.time
            rate.text = item.rate
            percent.text = item.percent
        }
        init {
            constraint.setOnClickListener {
                itemClick.invoke(adapterPosition)
            }
        }
    }

    inner class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}