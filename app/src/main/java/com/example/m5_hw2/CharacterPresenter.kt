package com.example.m5_hw2

import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class CharacterPresenter(
    private val dataSourceFactory: CharactersDataSourceFactory,
){
    private var view:CharactersView? = null

    fun getCharacters(){
        val config= PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20)
            .build()

        val pagedListLv=LivePagedListBuilder(dataSourceFactory,config).build()
        view?.getCharacters(pagedListLv)
    }

    fun attachView(view: CharactersView){
        this.view=view
    }

    fun detachView(){
        this.view=null
    }
}