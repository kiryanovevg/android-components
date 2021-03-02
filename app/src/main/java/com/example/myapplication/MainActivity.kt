package com.example.myapplication

import android.content.Context
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import com.example.myapplication.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

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

        log("onStop")
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

    private fun log(message: String) {
        Log.d(TAG, message)
    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
}
