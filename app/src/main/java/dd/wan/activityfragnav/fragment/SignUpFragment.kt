package dd.wan.activityfragnav.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dd.wan.activityfragnav.R
import kotlinx.android.synthetic.main.fragment_sign_up.view.*


class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        view.signUp.setOnClickListener {
            if(view.email.text.toString().trim().length>0 && view.email.passw.toString().trim().length>0)
            {
                val action = SignUpFragmentDirections.actionSignUpFragmentToLoginFragment(view.email.text.toString().trim(),view.passw.text.toString().trim())
                findNavController().navigate(action)
            }
        }
        view.login.setOnClickListener {
            findNavController().navigateUp()
        }
        view.forgotPass.setOnClickListener {
            findNavController().navigate(R.id.emailFragment)
        }
        return view
    }

}