package com.example.m5_hw2.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.m5_hw2.RetrofitService
import com.example.m5_hw2.data.Models.LoveModel
import com.example.m5_hw2.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveRepository {
    private val api = RetrofitService.api
    private val lovePercentageLv = MutableLiveData<LoveModel?>()
    fun getLovePercentage(firstName: String, secondName: String): MutableLiveData<LoveModel?> {
        api.getPercentage(
            apiKey = Constants.API_KEY,
            apiHost = Constants.API_HOST,
            firstName = firstName,
            secondName = secondName
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(p0: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful && response.body() != null) {
                    lovePercentageLv.postValue(response.body())
                }
            }

            override fun onFailure(p0: Call<LoveModel>, t: Throwable) {
                lovePercentageLv.postValue(null)
            }
        })
        return  lovePercentageLv
    }
}