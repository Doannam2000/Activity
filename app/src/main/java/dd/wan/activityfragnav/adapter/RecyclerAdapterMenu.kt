package dd.wan.activityfragnav.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dd.wan.activityfragnav.R
import dd.wan.activityfragnav.model.ListItem
import dd.wan.activityfragnav.model.item

class RecyclerAdapterMenu(var listItem: ArrayList<ListItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 1) {
            var view =
                LayoutInflater.from(parent.context).inflate(R.layout.header_menu, parent, false)
            return Header(view)
        } else if (viewType == 2) {
            var view =
                LayoutInflater.from(parent.context).inflate(R.layout.viewtype_1_menu, parent, false)
            return Header1(view)
        } else {
            var view =
                LayoutInflater.from(parent.context).inflate(R.layout.viewtype2_menu, parent, false)
            return Normal(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is Normal)
        {
            holder.image1.setImageResource(listItem.get(position-1).listItem.get(0).image)
            holder.image2.setImageResource(listItem.get(position-1).listItem.get(1).image)
            holder.image3.setImageResource(listItem.get(position-1).listItem.get(2).image)
            holder.image4.setImageResource(listItem.get(position-1).listItem.get(3).image)
            holder.name1.text = listItem.get(position-1).listItem.get(0).name
            holder.name2.text = listItem.get(position-1).listItem.get(1).name
            holder.name3.text = listItem.get(position-1).listItem.get(2).name
            holder.name4.text = listItem.get(position-1).listItem.get(3).name
            holder.nameList.text = listItem.get(position-1).nameList
        }
        else if(holder is Header1)
        {
            holder.image1.setImageResource(listItem.get(position-1).listItem.get(0).image)
            holder.image2.setImageResource(listItem.get(position-1).listItem.get(1).image)
            holder.image3.setImageResource(listItem.get(position-1).listItem.get(2).image)
            holder.image4.setImageResource(listItem.get(position-1).listItem.get(3).image)
            holder.name1.text = listItem.get(position-1).listItem.get(0).name
            holder.name2.text = listItem.get(position-1).listItem.get(1).name
            holder.name3.text = listItem.get(position-1).listItem.get(2).name
            holder.name4.text = listItem.get(position-1).listItem.get(3).name
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0)
            return 1
        else if (position == 1)
            return 2
        else
            return 3
    }

    override fun getItemCount(): Int {
        return listItem.size + 1
    }

    inner class Header(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    inner class Header1(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image1:ImageView = itemView.findViewById(R.id.image1)
        var image2:ImageView = itemView.findViewById(R.id.image2)
        var image3:ImageView = itemView.findViewById(R.id.image3)
        var image4:ImageView = itemView.findViewById(R.id.image4)
        var name1:TextView = itemView.findViewById(R.id.name1)
        var name2:TextView = itemView.findViewById(R.id.name2)
        var name3:TextView = itemView.findViewById(R.id.name3)
        var name4:TextView = itemView.findViewById(R.id.name4)
    }

    inner class Normal(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nameList:TextView = itemView.findViewById(R.id.nameList)
        var image1:ImageView = itemView.findViewById(R.id.imageItem1)
        var image2:ImageView = itemView.findViewById(R.id.imageItem2)
        var image3:ImageView = itemView.findViewById(R.id.imageItem3)
        var image4:ImageView = itemView.findViewById(R.id.imageItem4)
        var name1:TextView = itemView.findViewById(R.id.nameItem1)
        var name2:TextView = itemView.findViewById(R.id.nameItem2)
        var name3:TextView = itemView.findViewById(R.id.nameItem3)
        var name4:TextView = itemView.findViewById(R.id.nameItem4)
    }
}