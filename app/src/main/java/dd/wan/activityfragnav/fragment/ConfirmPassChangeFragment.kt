package dd.wan.activityfragnav.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dd.wan.activityfragnav.R
import kotlinx.android.synthetic.main.fragment_confirm_pass_change.view.*


class ConfirmPassChangeFragment : Fragment() {


    val args:ConfirmPassChangeFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_confirm_pass_change, container, false)
        val email = args.email
        view.btnLogin.setOnClickListener {
            val action = ConfirmPassChangeFragmentDirections.actionConfirmPassChangeFragmentToLoginFragment(email,"123")
            findNavController().navigate(action)
        }
        return view
    }

}