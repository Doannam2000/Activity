package dd.wan.activityfragnav.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dd.wan.activityfragnav.R
import dd.wan.activityfragnav.adapter.RecyclerAdapter1


class CoinFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_coin, container, false)
        var list = arrayOf("General", "Technical Section", "Markets", "Charts")
        var recycler: RecyclerView = view.findViewById(R.id.navbar)
        var layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recycler.layoutManager = layoutManager
        recycler.setHasFixedSize(true)
        recycler.adapter = RecyclerAdapter1(list)
        return  view
    }


}