package dd.wan.activityfragnav.fragment

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import dd.wan.activityfragnav.R
import dd.wan.activityfragnav.adapter.RecyclerAdapter1
import dd.wan.activityfragnav.adapter.RecyclerAdapterStock
import dd.wan.activityfragnav.model.Stock
import dd.wan.activityfragnav.model.color
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlin.random.Random

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)


        initRecyclerStock(view)
        initRecycler(view)

        // change color float button
        view.btnAlarm.setOnClickListener {
            val rnd = Random
            val color1 = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            view.btnAlarm.background.setTint(color1)
        }



        return view
    }

    fun initRecycler(view: View) {
        var list = arrayOf("INDEX", "SHARES", "CURRENCIES", "CRYPTO")
        var color = color("#ffffff", "#f21cc8", "#222222", "#f8f8f8")

        var adapter1 = RecyclerAdapter1(list, color)
//        adapter1.setCallback {
//
//        }

        var recycler: RecyclerView = view.findViewById(R.id.navbar)
        var layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recycler.layoutManager = layoutManager
        recycler.setHasFixedSize(true)
        recycler.adapter = adapter1
    }

    fun initRecyclerStock(view: View) {

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


        var recyclerAdapterStock = RecyclerAdapterStock(listStock)
        recyclerAdapterStock.setCallBack {
            val action = HomeFragmentDirections.actionHomeFragmentToCoinFragment(listStock.get(it))
            findNavController().navigate(action)
        }
        var recycleStock: RecyclerView = view.findViewById(R.id.recycleStock)
        recycleStock.layoutManager = LinearLayoutManager(context)
        recycleStock.setHasFixedSize(true)
        var dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        recycleStock.addItemDecoration(dividerItemDecoration)
        recycleStock.adapter = recyclerAdapterStock


        var stockDeleted: Stock
        // itemTouchHelper
        var itemTouchHelper =
            ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    var position = viewHolder.adapterPosition
                    when (direction) {
                        ItemTouchHelper.RIGHT -> {
                            stockDeleted = listStock.get(position)
                            listStock.removeAt(position)
                            recyclerAdapterStock.notifyDataSetChanged()
                            Snackbar.make(
                                recycleStock, stockDeleted.name+" deleted",
                                Snackbar.LENGTH_LONG
                            ).setAction("Undo", View.OnClickListener {
                                listStock.add(position,stockDeleted)
                                recyclerAdapterStock.notifyDataSetChanged()
                            }).show()
                        }
                    }
                }
            })
        itemTouchHelper.attachToRecyclerView(recycleStock)


        // button loadmore

        var listAdd = arrayListOf<Stock>(
            Stock("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("FTSE 100", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("IBEX 35", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("DAX", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("FTSE 100", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("IBEX 35", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("DAX", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("DOWN JONES", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)"),
            Stock("FTSE 100", "NYSE", "10:44:45", "20.047,50", "+203 (+1,04%)")
        )
        view.loadMore.setOnClickListener {
            recyclerAdapterStock.loadMore(listAdd)
        }
    }
}

