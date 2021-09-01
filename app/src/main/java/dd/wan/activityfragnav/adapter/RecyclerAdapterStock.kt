package dd.wan.activityfragnav.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dd.wan.activityfragnav.R
import dd.wan.activityfragnav.model.Stock

class RecyclerAdapterStock(var list: ArrayList<Stock>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var isFooter = false


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

//    override fun onBindViewHolder(holder: RecyclerAdapterStock.ViewHolder, position: Int) {
//
//    }

    override fun getItemViewType(position: Int): Int {
        if (position == list.size) {
            isFooter = true
            return 1
        } else {
            isFooter = false
            return 2
        }
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            var name: TextView = itemView.findViewById(R.id.name)
            var location: TextView = itemView.findViewById(R.id.location)
            var time: TextView = itemView.findViewById(R.id.time)
            var rate: TextView = itemView.findViewById(R.id.rate)
            var percent: TextView = itemView.findViewById(R.id.percent)
    }

    inner class FooterViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
    {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.name.text = list.get(position).name
            holder.location.text = list.get(position).location
            holder.time.text = list.get(position).time
            holder.rate.text = list.get(position).rate
            holder.percent.text = list.get(position).percent
        }

    }
}