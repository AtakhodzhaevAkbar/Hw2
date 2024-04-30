package com.example.m5_hw2.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.hw2.R
import com.example.m5_hw2.data.Models.LoveModel
import com.example.m5_hw2.RetrofitService
import com.example.m5_hw2.data.repository.LoveRepository
import com.example.m5_hw2.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val repository = LoveRepository()
    fun getLovePercentage(firstName: String, secondName: String): MutableLiveData<LoveModel?> =
        repository.getLovePercentage(firstName, secondName)


    private val errorLv = MutableLiveData<String>()
    fun getError(): LiveData<String> = errorLv

    private val loadingLv = MutableLiveData<Boolean>()
    fun getLoading(): LiveData<Boolean> = loadingLv


}
