package com.kiryanov.androidcomponents

import android.os.Bundle
import android.view.LayoutInflater
import com.kiryanov.androidcomponents.databinding.MainActivityBinding
import com.kiryanov.androidcomponents.ui.common.BindingActivity
import com.kiryanov.androidcomponents.ui.main.MainFragment

class MainActivity : BindingActivity<MainActivityBinding>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    override fun inflateBindingView(inflater: LayoutInflater): MainActivityBinding {
        return MainActivityBinding.inflate(inflater)
    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
    }
}
