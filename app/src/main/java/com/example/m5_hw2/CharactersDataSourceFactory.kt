package com.example.m5_hw2

import androidx.paging.DataSource
import com.example.m5_hw2.Models.Character

class CharactersDataSourceFactory(
): DataSource.Factory<Int, Character>() {
    override fun create(): DataSource<Int, Character> = CharactersDataSource()
}