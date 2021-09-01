package dd.wan.activityfragnav.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dd.wan.activityfragnav.R

class RecyclerAdapter1(var listItem:Array<String>) :RecyclerView.Adapter<RecyclerAdapter1.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter1.ViewHolder {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.listitem1,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter1.ViewHolder, position: Int) {
        holder.textView.text = listItem.get(position)
        if(position==0)
        {
            holder.textView.setTextColor(Color.parseColor("#ffffff"))
            holder.textView.setBackgroundColor(Color.parseColor("#f21cc8"))
        }
        else
        {
            holder.textView.setTextColor(Color.parseColor("#222222"))
            holder.textView.setBackgroundColor(Color.parseColor("#f8f8f8"))
        }
    }

    override fun getItemCount(): Int {
       return listItem.size
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
    {
        var textView:TextView = itemView.findViewById(R.id.Item)
    }
}