package com.example.m5_hw2.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hw2.R
import com.example.hw2.databinding.FragmentThirdBinding
import com.example.m5_hw2.data.network.Models.LoveModel
import com.example.m5_hw2.ViewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class ThirdFragment : Fragment() {
    private lateinit var binding: FragmentThirdBinding
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListeners()
    }
    private fun initClickListeners() = with(binding) {
        binding.btn.setOnClickListener {
            viewModel.getLovePercentage(
                firstName = etFname.text.toString(),
                secondName = etSname.text.toString(),
                lifecycleOwner = viewLifecycleOwner
            ).observe(viewLifecycleOwner) { data ->
                if (data != null) {
                    setupObservers(data)
                } else {
                    viewModel.error.observe(viewLifecycleOwner) { errorMessage ->
                        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }

    companion object {
        const val ARG_FIRST_NAME = "first_name"
        const val ARG_SECOND_NAME = "second_name"
        const val ARG_PERCENTAGE = "percentage"
        const val ARG_RESULT = "result"
    }

    private fun setupObservers(data: LoveModel) {
        val bundle = Bundle().apply {
            putString(ARG_FIRST_NAME, binding.etFname.text.toString())
            putString(ARG_SECOND_NAME, binding.etSname.text.toString())
            putString(ARG_PERCENTAGE, data.percentage)
            putString(ARG_RESULT, data.result)
        }
        findNavController().navigate(R.id.action_thirdFragment_to_fourthFragment2, bundle)
    }
}


