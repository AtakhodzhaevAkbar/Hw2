package com.example.m5_hw2.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw2.databinding.FragmentSecondScreenViewPagerBinding

class SecondScreenViewPager : Fragment() {
    private lateinit var binding: FragmentSecondScreenViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondScreenViewPagerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments!=null){
            val position=requireArguments().getInt(ARG_ONBOARD_POSITION)
            initialize()
        }
    }
    private fun initialize()=with(binding){
        when(requireArguments().getInt(ARG_ONBOARD_POSITION)){
            0->{
                mainTxt.text="Have a good time"
                secondTxt.text="You should take the time to help those who need you"
            }
            1->{
                mainTxt.text="Cherishing love"
                secondTxt.text="It is now no longer possible for you to cherish love"
            }
            2->{
                mainTxt.text="Have a breakup?"
                secondTxt.text="We have made the correction for you dont worry. Maybe Someone is waiting for you"
            }
        }
    }
    companion object{
        const val ARG_ONBOARD_POSITION="onBoard"
    }
}