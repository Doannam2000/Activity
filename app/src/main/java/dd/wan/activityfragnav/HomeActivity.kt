package dd.wan.activityfragnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dd.wan.activityfragnav.fragment.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar!!.hide()
        supportFragmentManager.beginTransaction().add(R.id.fragmentcontainer,MenuFragment()).commit()
    }
}