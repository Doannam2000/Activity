package dd.wan.activityfragnav.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dd.wan.activityfragnav.HomeActivity
import dd.wan.activityfragnav.R
import dd.wan.activityfragnav.SqlHelper
import dd.wan.activityfragnav.model.User
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_login.view.email
import kotlinx.android.synthetic.main.fragment_login.view.forgotPass
import kotlinx.android.synthetic.main.fragment_login.view.login
import kotlinx.android.synthetic.main.fragment_login.view.signUp
import kotlinx.android.synthetic.main.fragment_sign_up.view.*


class LoginFragment : Fragment() {

    val args: LoginFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_login, container, false)
        var sqlHelper = SqlHelper(requireContext())
        var arrayList: ArrayList<User> = sqlHelper.allData()
        view.email.setText(args.mail)
        view.password.setText(args.pass)

        view.forgotPass.setOnClickListener {
            if (!view.email.text.toString().isEmpty()) {
                var email = view.email.text.toString().trim()
                if (!sqlHelper.checkEmail(email)) {
                    val action = LoginFragmentDirections.actionLoginFragmentToEmailFragment(
                        view.email.text.toString().trim()
                    )
                    findNavController().navigate(action)
                } else {
                    Toast.makeText(context, "Email chưa tồn tại trong hệ thống !!!", Toast.LENGTH_LONG)
                        .show()
                }
            } else {
                Toast.makeText(context, "Bạn phải nhập email !!!", Toast.LENGTH_LONG).show()
            }
        }
        view.signUp.setOnClickListener {
            findNavController().navigate(R.id.signUpFragment)
        }
        view.login.setOnClickListener {
            if (view.email.text.toString().trim().length> 0 && view.password.text.toString().length>0) {
                val email = view.email.text.toString().trim()
                val password = view.password.text.toString().trim()
                var index = 0
                for (item in arrayList) {
                    if (item.email.equals(email) && item.password.equals(password)) {
                        index = 1
                        startActivity(
                            Intent(
                                activity,
                                HomeActivity::class.java
                            ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                        )
                    }
                }
                if (index == 0)
                    Toast.makeText(
                        context,
                        "Tài khoản hoặc mật khẩu không chính xác !!!",
                        Toast.LENGTH_LONG
                    ).show()
            } else {
                Toast.makeText(context, "Bạn phải nhập đầy đủ thông tin !!!", Toast.LENGTH_LONG).show()
            }
        }
        return view
    }
}