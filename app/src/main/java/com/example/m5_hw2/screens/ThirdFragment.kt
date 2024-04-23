package com.example.m5_hw2.screens

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.hw2.R
import com.example.hw2.databinding.FragmentThirdBinding
import com.example.m5_hw2.Models.LoveModel
import com.example.m5_hw2.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdFragment : Fragment() {
    private lateinit var binding: FragmentThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Ваш код в ThirdFragment.kt
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListeners()
    }

    private fun initClickListeners() = with(binding) {
        btn.setOnClickListener {
            RetrofitService.api.getPercentage(
                firstName = etFname.text.toString(),
                secondName = etSname.text.toString(),
            ).enqueue(object : Callback<LoveModel> {
                override fun onResponse(p0: Call<LoveModel>, response: Response<LoveModel>) {
                    if (response.isSuccessful && response.body() != null) {
                        val loveModel = response.body()!!
                        Log.d(
                            "ThirdFragment",
                            "Response: ${response.body()!!.percentage}"
                        )
                        val bundle = Bundle().apply {
                            putString("firstName", etFname.text.toString())
                            putString("secondName", etSname.text.toString())
                            putString("percentage", loveModel.percentage)
                        }
                        findNavController().navigate(
                            R.id.action_thirdFragment_to_fourthFragment2,
                            bundle
                        )
                    }

                }

                override fun onFailure(p0: Call<LoveModel>, t: Throwable) {
                    Toast.makeText(requireContext(), t.localizedMessage, Toast.LENGTH_SHORT).show()
                    Log.e(
                        "ThirdFragment",
                        "Error: ${t.localizedMessage}"
                    )
                }
            })
        }
    }
}