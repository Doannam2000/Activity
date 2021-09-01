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
import dd.wan.activityfragnav.adapter.RecyclerAdapterProduct
import dd.wan.activityfragnav.model.Product


class NewsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_news, container, false)

        var list = arrayListOf<Product>(
            Product(
                R.drawable.product1,
                "ATLANTIA",
                "ALT -3,87%",
                "3 Sept 2020",
                "Illum velit nam voluptatum enim aut\nratione ratione officiis totam.\nMollitia eum sint tempora ducimus"
            ),Product(
                R.drawable.product_2,
                "XIAOMI",
                "HKD -2,13%",
                "2 Sept 2020",
                "Illum velit nam voluptatum enim aut\nratione ratione officiis totam.\nMollitia eum sint tempora ducimus"
            ),Product(
                R.drawable.product1,
                "APPLE",
                "AAPL -0,91%",
                "1 Sept 2020",
                "Illum velit nam voluptatum enim aut\nratione ratione officiis totam.\nMollitia eum sint tempora ducimus"
            )
        )

        var recycler: RecyclerView = view.findViewById(R.id.recyclerProduct)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.setHasFixedSize(true)
        recycler.adapter = RecyclerAdapterProduct(list)

        var list1 = arrayOf("EDITORIAL", "CRYPTO NEWS", "RAW MATERIAL", "ECONOMICS")
        var recycler1: RecyclerView = view.findViewById(R.id.navbar)
        var layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recycler1.layoutManager = layoutManager
        recycler1.setHasFixedSize(true)
        recycler1.adapter = RecyclerAdapter1(list1)

        return view
    }

}