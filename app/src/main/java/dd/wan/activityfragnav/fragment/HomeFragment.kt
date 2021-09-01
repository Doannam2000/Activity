package dd.wan.activityfragnav.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dd.wan.activityfragnav.R
import dd.wan.activityfragnav.adapter.RecyclerAdapter1
import dd.wan.activityfragnav.adapter.RecyclerAdapterStock
import dd.wan.activityfragnav.model.Stock

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)
        var list = arrayOf("INDEX", "SHARES", "CURRENCIES", "CRYPTO")

        var recycler: RecyclerView = view.findViewById(R.id.navbar)
        var layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recycler.layoutManager = layoutManager
        recycler.setHasFixedSize(true)
        recycler.adapter = RecyclerAdapter1(list)

        var listStock = arrayListOf<Stock>(
            Stock("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("FTSE 100", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("IBEX 35", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("DAX", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("FTSE 100", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("IBEX 35", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("DAX", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("FTSE 100", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("IBEX 35", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("DAX", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)")
        )

        var recycleStock: RecyclerView = view.findViewById(R.id.recycleStock)
        recycleStock.layoutManager = LinearLayoutManager(context)
        recycleStock.setHasFixedSize(true)
        var dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        recycleStock.addItemDecoration(dividerItemDecoration)
        recycleStock.adapter = RecyclerAdapterStock(listStock)
        return view
    }

}