package com.example.myapplication

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.ui.main.MainFragment
import java.util.concurrent.ThreadLocalRandom

class MainActivity : AppCompatActivity(), LifecycleLogging {

    override val rId: Int = ThreadLocalRandom.current().nextInt(0, 100)

    init {
        log("Primary constructor")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }

        log("onCreate")
    }

    override fun onRestart() {
        super.onRestart()

        log("onRestart")
    }

    override fun onStart() {
        super.onStart()

        log("onStart")
    }

    override fun onResume() {
        super.onResume()

        log("onResume")
    }

    override fun onPause() {
        super.onPause()

        log("onPause")
    }

    override fun onStop() {
        super.onStop()

        log("onStop; isChangingConfigurations: $isChangingConfigurations")
    }

    override fun onDestroy() {
        super.onDestroy()

        log("onDestroy")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        log("onRestoreInstanceState")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        log("onSaveInstanceState")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        log("onConfigurationChanged")
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)

        log("attachBaseContext")
    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
}
