package dd.wan.activityfragnav.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dd.wan.activityfragnav.MainActivity
import dd.wan.activityfragnav.R
import kotlinx.android.synthetic.main.fragment_on_boarding3.view.*


class OnBoarding3Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_on_boarding3, container, false)
        view.back.setOnClickListener {
            findNavController().navigateUp()
        }
        view.skip.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
        }
        view.btnNext.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
        }
        return view
    }

}