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
import kotlinx.android.synthetic.main.fragment_on_boarding.view.*


class OnBoardingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_on_boarding, container, false)
        view.btnNext.setOnClickListener {
            findNavController().navigate(R.id.onBoarding2Fragment)
        }
        view.skip.setOnClickListener {
            startActivity(Intent(activity,MainActivity::class.java))
        }
        return  view
    }
}