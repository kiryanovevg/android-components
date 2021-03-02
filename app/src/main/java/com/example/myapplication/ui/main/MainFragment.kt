package com.example.myapplication.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.LifecycleLogging
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import java.util.concurrent.ThreadLocalRandom

class MainFragment : Fragment(), LifecycleLogging {

    override val rId: Int = ThreadLocalRandom.current().nextInt(0, 100)

    private lateinit var viewModel: MainViewModel

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        log("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        retainInstance = true
        log("onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        log("onCreateView")
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        log("onViewCreated")

        val tvObject = view.findViewById<TextView>(R.id.tvObject)
        val btnLog = view.findViewById<Button>(R.id.btnLog)
        val btnOpenActivity = view.findViewById<Button>(R.id.btnOpenActivity)
        val btnReplaceFragment = view.findViewById<Button>(R.id.btnReplaceFragment)

        val text = "Activity: $activity\nFragment: $this"
        tvObject.text = text

        btnLog.setOnClickListener {
            log("--- Button clicked! ---")
        }

        btnOpenActivity.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }

        btnReplaceFragment.setOnClickListener {
            requireFragmentManager().beginTransaction()
                .replace(R.id.container, newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        log("onActivityCreated")
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

    override fun onDestroyView() {
        super.onDestroyView()

        log("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()

        log("onDestroy")
    }

    override fun onDetach() {
        super.onDetach()

        log("onDetach")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        log("onSaveInstanceState")
    }

    companion object {
        val TAG = MainFragment::class.java.simpleName

        fun newInstance() = MainFragment()
    }
}
