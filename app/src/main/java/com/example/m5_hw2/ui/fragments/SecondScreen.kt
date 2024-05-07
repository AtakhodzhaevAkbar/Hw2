package com.example.m5_hw2.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.hw2.R
import com.example.hw2.databinding.FragmentSecondScreenBinding
import com.example.m5_hw2.adapter.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondScreen : Fragment() {
    private lateinit var binding: FragmentSecondScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentSecondScreenBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isFirstTime()) {
            initialize()
            setupListener()
            markOnboardingAsShown()
        } else {
            findNavController().navigate(R.id.action_secondScreen_to_zeroFragment)
        }
    }
    private fun isFirstTime(): Boolean {
        val sharedPreferences = requireContext().getSharedPreferences("onboarding_prefs", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("onboarding_shown", false).not()
    }
    private fun markOnboardingAsShown() {
        val sharedPreferences = requireContext().getSharedPreferences("onboarding_prefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putBoolean("onboarding_shown", true).apply()
    }

    private fun initialize() {
        binding.viewPager.adapter = ViewPagerAdapter(this@SecondScreen)
    }
    private fun setupListener() {

        binding.onBtnBeggin.setOnClickListener {
            findNavController().navigate(R.id.action_secondScreen_to_zeroFragment)
        }

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 2) {
                    binding.onBtnBeggin.visibility = View.VISIBLE
                } else {
                    binding.onBtnBeggin.visibility = View.GONE
                }
            }
        })
    }
}