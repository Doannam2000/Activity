package dd.wan.activityfragnav.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dd.wan.activityfragnav.R
import dd.wan.activityfragnav.adapter.RecyclerAdapterMenu
import dd.wan.activityfragnav.model.ListItem
import dd.wan.activityfragnav.model.item
import kotlinx.android.synthetic.main.fragment_menu.view.*


class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_menu, container, false)
        view.back.setOnClickListener {
            findNavController().navigateUp()
        }
        var listitem1 = arrayListOf<item>(
            item(R.drawable.icons_8_alarm,"Alerts"),
            item(R.drawable.icons_8_left_and_right_arrows,"Predictions"),
            item(R.drawable.icons_8_pin,"Saved elements"),
            item(R.drawable.icons_8_no_entry,"Remove Ads")
        )

        var listitem2 = arrayListOf<item>(
            item(R.drawable.icons_8_profit_2,"Select Stocks"),
            item(R.drawable.icons_8_swap,"Currency Exchange"),
            item(R.drawable.icons_8_video_call,"Webinar"),
            item(R.drawable.icons_8_rent,"Best Broker")
        )


        var list = arrayListOf<ListItem>(
            ListItem("name",listitem1),
            ListItem("Tools",listitem2),
            ListItem("Markets",listitem2)
        )

        var recyclerView:RecyclerView = view.findViewById(R.id.recyclerMenu)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = RecyclerAdapterMenu(list)
        return view
    }

}