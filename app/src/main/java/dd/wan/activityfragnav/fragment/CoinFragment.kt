package dd.wan.activityfragnav.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dd.wan.activityfragnav.R
import dd.wan.activityfragnav.adapter.RecyclerAdapter1
import dd.wan.activityfragnav.model.color
import kotlinx.android.synthetic.main.fragment_coin.view.*


class CoinFragment : Fragment() {

    val args: CoinFragmentArgs by navArgs()

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_coin, container, false)

        if(args.stock != null)
        {
            val stock = args.stock
            view.rate.text = stock!!.rate
            view.nameStock.text = stock.name
            view.nameStockChart.text = stock.name +" Chart"
            view.time.text = stock.time +" Real time"
            view.percent.text = stock.percent

        }

        view.back.setOnClickListener {
            findNavController().navigateUp()
        }

        val list = arrayOf("General", "Technical Section", "Markets", "Charts")
        val color = color("#ffffff","#f21cc8","#222222","#f8f8f8")
        val recycler: RecyclerView = view.findViewById(R.id.navbar)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recycler.layoutManager = layoutManager
        recycler.setHasFixedSize(true)
        recycler.adapter = RecyclerAdapter1(list,color)


        return  view
    }


}