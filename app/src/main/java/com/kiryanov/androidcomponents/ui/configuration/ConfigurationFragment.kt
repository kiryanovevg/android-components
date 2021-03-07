package com.kiryanov.androidcomponents.ui.configuration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.kiryanov.androidcomponents.R
import com.kiryanov.androidcomponents.databinding.FragmentConfigurationBinding
import com.kiryanov.androidcomponents.ui.common.BindingFragment
import java.util.concurrent.ThreadLocalRandom

class ConfigurationFragment : BindingFragment<FragmentConfigurationBinding>(),
    LifecycleLogging {

    override val rId: Int = ThreadLocalRandom
        .current()
        .nextInt(0, 100)

    private val isRetained: Boolean
        get() = arguments?.getBoolean(KEY_RETAIN, false)
            ?: throw IllegalArgumentException("Use newInstance() fun!")

    private val adapter = BackStackAdapter()

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

        retainInstance = isRetained
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

        val text = "Activity: $activity\n\nFragment: $this;\nisRetained: $isRetained"
        binding.tvObject.text = text

        binding.btnLog.setOnClickListener {
            log("--- Button clicked! ---")
        }

        binding.btnOpenActivity.setOnClickListener {
            startActivity(Intent(requireContext(), ConfigurationActivity::class.java))
        }

        binding.btnReplaceFragment.setOnClickListener {
            val isRetained = binding.cbRetain.isChecked
            val addToBackStack = binding.cbBackStack.isChecked

            replaceFragment(isRetained, addToBackStack)
        }

        binding.rvBackStack.layoutManager = LinearLayoutManager(requireContext())
        binding.rvBackStack.adapter = adapter

        val list = arrayListOf<BackStackAdapter.Item>().apply {
            repeat(parentFragmentManager.backStackEntryCount) {
                val entry = parentFragmentManager.getBackStackEntryAt(it)
                add(
                    BackStackAdapter.Item(
                        entry.id,
                        entry.name ?: "---"
                    )
                )
            }
        }

        adapter.submitList(list)
    }

    private fun replaceFragment(isRetained: Boolean, addToBackStack: Boolean) {
        parentFragmentManager.beginTransaction()
            .replace(R.id.container_configuration, newInstance(isRetained), TAG)
            .apply {
                if (addToBackStack) addToBackStack(null)
            }
            .commit()
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

        private const val KEY_RETAIN = "keyRetain"

        fun newInstance(isRetained: Boolean) =
            ConfigurationFragment().apply {
                arguments = bundleOf(
                    KEY_RETAIN to isRetained
                )
            }
    }
}