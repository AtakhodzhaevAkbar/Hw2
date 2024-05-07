package com.example.m5_hw2.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.m5_hw2.data.local.dao.LoveDao
import com.example.m5_hw2.data.local.entities.History
import com.example.m5_hw2.data.network.LoveApiService
import com.example.m5_hw2.data.network.Models.LoveModel
import com.example.m5_hw2.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoveRepository @Inject constructor(
    private val api: LoveApiService,
    private val dao: LoveDao
) {
    suspend fun getAllHistory(): List<History> {
        return dao.getAllHistory()
    }
    fun deleteHistory(historyId: Int) {
        dao.deleteHistory(historyId)
    }

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
        return lovePercentageLv
    }
}
