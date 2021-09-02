package dd.wan.activityfragnav.fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dd.wan.activityfragnav.R
import kotlinx.android.synthetic.main.fragment_email.view.*


class EmailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_email, container, false)

        var time = 5
        var mHandler: Handler = @SuppressLint("HandlerLeak")
        object : Handler() {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                when (msg.what) {
                    1 -> {
                        view.waitingTime.text = "Wait ${msg.arg1} seconds before sending it"
                        if(msg.arg1==0)
                        {
                            view.resendEmail.isEnabled = true
                            view.resendEmail.alpha = 1F
                        }
                    }
                }
            }
        }
        Thread(Runnable {
            while (time > 0) {
                time--
                val message = Message()
                message.what = 1
                message.arg1 = time
                Thread.sleep(1000)
                mHandler.sendMessage(message)
            }
        }).start()

        view.resendEmail.setOnClickListener {
            findNavController().navigate(R.id.confirmPassChangeFragment)
        }
        return view
    }

}