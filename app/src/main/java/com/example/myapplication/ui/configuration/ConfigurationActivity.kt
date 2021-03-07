package com.example.myapplication.ui.configuration

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityConfigurationBinding
import com.example.myapplication.ui.common.BindingActivity
import java.util.concurrent.ThreadLocalRandom

class ConfigurationActivity : BindingActivity<ActivityConfigurationBinding>(), LifecycleLogging {

    override val rId: Int = ThreadLocalRandom
        .current()
        .nextInt(0, 100)

    override fun inflateBindingView(inflater: LayoutInflater): ActivityConfigurationBinding {
        return ActivityConfigurationBinding.inflate(inflater)
    }

    init {
        log("Primary constructor")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        log("onCreate")

        supportFragmentManager.findFragmentById(R.id.container_configuration) ?: run {
            supportFragmentManager.beginTransaction().replace(
                R.id.container_configuration,
                ConfigurationFragment.newInstance(),
                ConfigurationFragment.TAG
            ).commitNow()
        }
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
        val TAG = ConfigurationActivity::class.java.simpleName

        fun getIntent(context: Context) = Intent(context, ConfigurationActivity::class.java)
    }
}