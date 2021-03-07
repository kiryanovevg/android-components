package com.example.myapplication.ui.common

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BindingActivity<T : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: T

    abstract fun inflateBindingView(inflater: LayoutInflater): T

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateBindingView(layoutInflater)
        setContentView(binding.root)
    }
}