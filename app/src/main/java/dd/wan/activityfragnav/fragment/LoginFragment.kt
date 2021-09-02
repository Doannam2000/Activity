package dd.wan.activityfragnav.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dd.wan.activityfragnav.HomeActivity
import dd.wan.activityfragnav.R
import kotlinx.android.synthetic.main.fragment_login.view.*


class LoginFragment : Fragment() {

    val args: LoginFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_login, container, false)

        view.email.setText(args.mail)
        view.password.setText(args.pass)

        view.forgotPass.setOnClickListener {
            findNavController().navigate(R.id.emailFragment)
        }
        view.signUp.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
        }
        view.login.setOnClickListener {
            startActivity(Intent(activity, HomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK))
        }
        return view
    }
}