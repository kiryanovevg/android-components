package com.example.myapplication.ui.configuration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentConfigurationBinding
import com.example.myapplication.ui.common.BindingFragment
import java.util.concurrent.ThreadLocalRandom

class ConfigurationFragment : BindingFragment<FragmentConfigurationBinding>(),
    LifecycleLogging {

    override val rId: Int = ThreadLocalRandom
        .current()
        .nextInt(0, 100)

    override fun inflateBindingView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        attachToRoot: Boolean
    ): FragmentConfigurationBinding = FragmentConfigurationBinding.inflate(
        inflater, parent, attachToRoot
    )

    override fun onAttach(context: Context) {
        log("onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        retainInstance = true
        log("onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        log("onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        log("onViewCreated")

        val text = "Activity: $activity\nFragment: $this"
        binding.tvObject.text = text

        binding.btnLog.setOnClickListener {
            log("--- Button clicked! ---")
        }

        binding.btnOpenActivity.setOnClickListener {
            startActivity(Intent(requireContext(), ConfigurationActivity::class.java))
        }

        binding.btnReplaceFragment.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container_configuration, newInstance(), TAG)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

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
        val TAG = ConfigurationFragment::class.java.simpleName

        fun newInstance() = ConfigurationFragment()
    }
}