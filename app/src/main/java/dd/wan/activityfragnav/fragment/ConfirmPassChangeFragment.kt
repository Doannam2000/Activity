package dd.wan.activityfragnav.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dd.wan.activityfragnav.R
import kotlinx.android.synthetic.main.fragment_confirm_pass_change.view.*


class ConfirmPassChangeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_confirm_pass_change, container, false)
        view.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
        return view
    }

}