package dd.wan.activityfragnav.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import dd.wan.activityfragnav.R
import dd.wan.activityfragnav.SqlHelper
import kotlinx.android.synthetic.main.fragment_sign_up.view.*


class SignUpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        var sqlHelper = SqlHelper(requireContext())

        view.signUp.setOnClickListener {
            if (!view.email.text.toString().trim().isEmpty() && !view.passw.text.toString().trim()
                    .isEmpty()
            ) {
                var mail = view.email.text.toString().trim()
                var password = view.passw.text.toString().trim()
                if (sqlHelper.insertData(mail, password)) {
                    val action =
                        SignUpFragmentDirections.actionSignUpFragmentToLoginFragment(mail, password)
                    findNavController().navigate(action)
                } else {
                    Toast.makeText(context, "Email đã tồn tại !!!", Toast.LENGTH_LONG).show()
                }
            }
        }
        view.login.setOnClickListener {
            findNavController().navigateUp()
        }
        view.forgotPass.setOnClickListener {
            if (!view.email.text.toString().trim().isEmpty()) {
                var email = view.email.text.toString().trim()
                if (!sqlHelper.checkEmail(email)) {
                    val action = SignUpFragmentDirections.actionSignUpFragmentToEmailFragment(email)
                    findNavController().navigate(action)
                } else {
                    Toast.makeText(context, "Email chưa tồn tại trong hệ thống", Toast.LENGTH_LONG)
                        .show()
                }
            } else {
                Toast.makeText(context, "Bạn phải nhập email !!!", Toast.LENGTH_LONG).show()
            }
        }
        return view
    }

}