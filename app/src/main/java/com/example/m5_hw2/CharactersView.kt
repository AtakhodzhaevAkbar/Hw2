package com.example.m5_hw2

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.m5_hw2.Models.Character

interface CharactersView {
    fun getCharacters(data: LiveData<PagedList<Character>>)
}