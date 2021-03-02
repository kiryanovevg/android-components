package com.example.myapplication

import android.app.Activity
import android.util.Log
import androidx.fragment.app.Fragment

interface LifecycleLogging {

    val rId: Int

    fun Activity.log(message: String) {
        Log.d(TAG, "Activity: $rId - $message")
    }

    fun Fragment.log(message: String) {
        Log.d(TAG, "Fragment: $rId - $message")
    }

    companion object {
        private const val TAG = "Lifecycle"
    }
}