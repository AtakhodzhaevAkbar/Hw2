package com.example.m5_hw2

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.example.m5_hw2.Models.Character
import com.example.m5_hw2.Models.CharactersResponce
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val INITIAL_INDEX = 1

class CharactersDataSource(
) : PageKeyedDataSource<Int, Character>() {
    val loadState = MutableLiveData<Int>()
    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {

        val currentIndex=params.key

        RetrofitService.api.getCharacters(
            INITIAL_INDEX
        ).enqueue(object : Callback<CharactersResponce> {
            override fun onResponse(
                call: Call<CharactersResponce>,
                response: Response<CharactersResponce>
            ) {
                if(response.isSuccessful&& response.body()!=null){
                    callback.onResult(response.body()!!.results, currentIndex+1)
                }
            }

            override fun onFailure(call: Call<CharactersResponce>, t: Throwable) {
                Log.e("error","OnFauilure:${t.localizedMessage}")
            }

        })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
        //TODO("Not yet implemented")
    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Character>
    ) {
        RetrofitService.api.getCharacters(
            INITIAL_INDEX
        ).enqueue(object : Callback<CharactersResponce> {
            override fun onResponse(
                call: Call<CharactersResponce>,
                response: Response<CharactersResponce>
            ) {
                if(response.isSuccessful&& response.body()!=null){
                    callback.onResult(response.body()!!.results,null, INITIAL_INDEX+1)
                }
            }

            override fun onFailure(call: Call<CharactersResponce>, t: Throwable) {
                Log.e("error","OnFauilure:${t.localizedMessage}")
            }

        })
    }
}