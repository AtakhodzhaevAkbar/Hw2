package com.example.m5_hw2.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw2.databinding.FragmentFourthBinding



class FourthFragment : Fragment() {
    private lateinit var binding: FragmentFourthBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentFourthBinding.inflate(inflater,container,false)
        return binding.root
    }
    // Ваш код в FourthFragment.kt
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получение переданных данных из Bundle
        val firstName = arguments?.getString("firstName")
        val secondName = arguments?.getString("secondName")
        val percentage = arguments?.getString("percentage")

        // Отображение данных
        binding.TVFname.text = firstName
        binding.TVSname.text = secondName
        binding.TVPercentage.text = percentage.toString()
    }

}
