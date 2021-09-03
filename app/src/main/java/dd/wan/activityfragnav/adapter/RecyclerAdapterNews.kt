package dd.wan.activityfragnav.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import dd.wan.activityfragnav.R
import dd.wan.activityfragnav.model.New

class RecyclerAdapterNews(var listItem: ArrayList<New>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    lateinit var itemClick: (position: Int) -> Unit

    fun setCallBack(click: (position: Int) -> Unit) {
        itemClick = click
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 2) {
            var view =
                LayoutInflater.from(parent.context).inflate(R.layout.listproduct, parent, false)
            return ViewHolder(view)
        } else {
            var view =
                LayoutInflater.from(parent.context).inflate(R.layout.headerproduct, parent, false)
            return HeaderHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.setData(listItem.get(position - 1))
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
            return 1
        else return 2
    }

    override fun getItemCount(): Int {
        return listItem.size + 1
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name1: TextView = itemView.findViewById(R.id.nameProduct)
        var image: ImageView = itemView.findViewById(R.id.imageProduct)
        var time: TextView = itemView.findViewById(R.id.timeProduct)
        var description: TextView = itemView.findViewById(R.id.description)
        var percent: TextView = itemView.findViewById(R.id.percentProduct)
        var layout:ConstraintLayout = itemView.findViewById(R.id.constraint)
        fun setData(aNew:New) {
            name1.text = aNew.name
            time.text = aNew.time
            description.text = aNew.description
            percent.text = aNew.percent
            image.setImageResource(aNew.img)
        }
        init {
            layout.setOnClickListener {
                itemClick.invoke(adapterPosition-1)
            }
        }
    }

    inner class HeaderHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}