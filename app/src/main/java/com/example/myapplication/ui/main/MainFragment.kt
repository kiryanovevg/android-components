package com.example.myapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.ui.common.BindingFragment
import com.example.myapplication.ui.configuration.ConfigurationActivity

class MainFragment : BindingFragment<FragmentMainBinding>() {

    private val adapter = ComponentAdapter()

    override fun inflateBindingView(
        inflater: LayoutInflater,
        parent: ViewGroup?,
        attachToRoot: Boolean
    ): FragmentMainBinding = FragmentMainBinding.inflate(
        inflater, parent, attachToRoot
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter.onItemClickListener = { category ->
            when (category) {
                ComponentType.CONFIGURATION -> {
                    startActivity(ConfigurationActivity.getIntent(requireContext()))
                }
                ComponentType.SERVICE -> {
                    Toast.makeText(context, "Not impl", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
