package com.example.m5_hw2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw2.R
import com.example.hw2.databinding.FragmentFourthBinding
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class FourthFragment : Fragment() {
    private lateinit var binding: FragmentFourthBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFourthBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val firstName = arguments?.getString("first_name")
        val secondName = arguments?.getString("second_name")
        val percentage = arguments?.getString("percentage")

        binding.TVFname.text = firstName
        binding.TVSname.text = secondName
        binding.TVPercentage.text = percentage.toString()
        binding.btnContinue.setOnClickListener {
            findNavController().navigate(R.id.action_fourthFragment_to_fifthFragment)
        }
    }

}
