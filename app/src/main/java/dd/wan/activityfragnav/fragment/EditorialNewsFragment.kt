package dd.wan.activityfragnav.fragment

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
import kotlinx.android.synthetic.main.fragment_editorial_news.view.*

class EditorialNewsFragment : Fragment() {

    val args : EditorialNewsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_editorial_news, container, false)

        // nhan du lieu
        if(args.news != null)
        {
            val news = args.news
            view.nameNews.text = news!!.name
        }


        view.back.setOnClickListener {
            findNavController().navigateUp()
        }


        // menu
        var list = arrayOf("EDITORIAL", "CRYPTO NEWS", "RAW MATERIAL", "ECONOMICS")
        var color = color("#222222","#00ffba","#222222","#f8f8f8")
        var recycler: RecyclerView = view.findViewById(R.id.navbar)
        var layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recycler.layoutManager = layoutManager
        recycler.setHasFixedSize(true)
        recycler.adapter = RecyclerAdapter1(list,color)



        return view
    }

}