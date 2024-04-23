package com.example.m5_hw2.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.m5_hw2.screens.SecondScreenViewPager
import com.example.m5_hw2.screens.SecondScreenViewPager.Companion.ARG_ONBOARD_POSITION

class ViewPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int)= SecondScreenViewPager().apply {
        arguments= Bundle().apply {
            putInt(ARG_ONBOARD_POSITION, position)
        }
    }
}