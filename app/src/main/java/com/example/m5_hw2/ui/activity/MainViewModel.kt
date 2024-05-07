package com.example.m5_hw2.ui.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.m5_hw2.data.network.Models.LoveModel
import com.example.m5_hw2.data.repository.LoveRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: LoveRepository
) : ViewModel() {

    fun getLovePercentage(firstName: String, secondName: String): MutableLiveData<LoveModel?> =
        repository.getLovePercentage(firstName, secondName)


    private val errorLv = MutableLiveData<String>()
    fun getError(): LiveData<String> = errorLv

    private val loadingLv = MutableLiveData<Boolean>()
    fun getLoading(): LiveData<Boolean> = loadingLv


}
