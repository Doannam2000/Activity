package dd.wan.activityfragnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class TutorialActitity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_actitity)
        supportActionBar!!.hide()
    }
}