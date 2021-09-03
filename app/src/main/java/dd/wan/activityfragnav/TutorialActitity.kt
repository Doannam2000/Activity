package dd.wan.activityfragnav

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TutorialActitity : AppCompatActivity() {
    var isRemember = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_actitity)
        supportActionBar!!.hide()
    }
}