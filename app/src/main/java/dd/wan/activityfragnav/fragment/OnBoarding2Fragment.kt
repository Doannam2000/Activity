package dd.wan.activityfragnav.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dd.wan.activityfragnav.MainActivity
import dd.wan.activityfragnav.R
import kotlinx.android.synthetic.main.fragment_on_boarding2.view.*


class OnBoarding2Fragment : Fragment() {

    lateinit var sharedPreferences:SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_on_boarding2, container, false)
        view.back.setOnClickListener {
            findNavController().navigateUp()
        }
        view.btnNext.setOnClickListener {
            findNavController().navigate(R.id.onBoarding3Fragment)
        }
        view.skip.setOnClickListener {
            sharedPreferences = requireActivity().getSharedPreferences("SHARE_PREFERENCES", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putBoolean("check",true)
            editor.apply()
            startActivity(Intent(activity,MainActivity::class.java))
            startActivity(Intent(activity, MainActivity::class.java))
        }
        return view
    }
}