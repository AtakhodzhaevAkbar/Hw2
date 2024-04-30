package com.example.m5_hw2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw2.R
import com.example.hw2.databinding.FragmentFirstScreenBinding




class FirstScreen : Fragment() {
    private lateinit var binding: FragmentFirstScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentFirstScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListeners()
    }

    private fun initClickListeners() {
        binding.btnStart.setOnClickListener {
            findNavController().navigate(R.id.action_firstScreen_to_secondScreen)
        }
    }

}