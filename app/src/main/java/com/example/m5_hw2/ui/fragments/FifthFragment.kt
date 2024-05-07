package com.example.m5_hw2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw2.databinding.FragmentFifthBinding
import com.example.m5_hw2.ViewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.example.m5_hw2.adapter.HistoryAdapter

@AndroidEntryPoint
class FifthFragment : Fragment() {
    private lateinit var binding: FragmentFifthBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFifthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = HistoryAdapter(requireContext(), viewModel)
        binding.historyRecyclerView.adapter = adapter
        binding.historyRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        viewModel.historyList.observe(viewLifecycleOwner) { historyList ->
            adapter.submitList(historyList)
        }
    }
}
