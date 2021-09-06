package dd.wan.activityfragnav

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.custom_dialog.*
import kotlinx.android.synthetic.main.custom_dialog.view.*


class HomeActivity : AppCompatActivity() {
    lateinit var navHostFragment: NavHostFragment
    lateinit var controller: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar!!.hide()
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        controller = navHostFragment.navController
        bottomNavigationView.setupWithNavController(controller)
    }

    override fun onNavigateUp(): Boolean {
        return controller.navigateUp() || super.onNavigateUp()
    }

    override fun onBackPressed() {
        if (navHostFragment.childFragmentManager.backStackEntryCount == 0) {

            // Cách 1
//            val dialog = Dialog(this)
//            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//            dialog.setContentView(R.layout.custom_dialog)
//            val window = dialog.window
//            if (window != null) {
//                window.setLayout(
//                    WindowManager.LayoutParams.MATCH_PARENT,
//                    WindowManager.LayoutParams.WRAP_CONTENT
//                )
//                window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//                val windowAttribute = window.attributes
//                windowAttribute.gravity = Gravity.CENTER
//                window.attributes = windowAttribute
//
//                if (Gravity.BOTTOM == Gravity.CENTER) {
//                    dialog.setCancelable(true)
//                } else {
//                    dialog.setCancelable(false)
//                }
//                dialog.cancel.setOnClickListener {
//                    dialog.dismiss()
//                }
//                dialog.exit.setOnClickListener {
//                    dialog.dismiss()
//                    super.onBackPressed()
//                }
//            }
//            dialog.show()


            // Cách 2
            val view = View.inflate(this, R.layout.custom_dialog, null)
            var builder = AlertDialog.Builder(this)
            builder.setView(view)

            val dialog = builder.create()
            dialog.show()
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            view.cancel.setOnClickListener {
                dialog.dismiss()
            }
            view.exit.setOnClickListener {
                dialog.dismiss()
                super.onBackPressed()
            }


        } else {
            super.onBackPressed()
        }
    }
}