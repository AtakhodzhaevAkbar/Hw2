package com.example.m5_hw2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.hw2.R
import com.example.hw2.databinding.ActivityMainBinding
import com.example.m5_hw2.Models.Character


class MainActivity : AppCompatActivity(),CharactersView {
    private lateinit var binding: ActivityMainBinding
    private var characterAdapter=CharacterAdapter()
    private val presenter by lazy {
        CharacterPresenter(
            CharactersDataSourceFactory()
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        presenter.getCharacters()
        }

    override fun getCharacters(data: LiveData<PagedList<Character>>) {
        data.observe(this){
            binding.charactersRV.apply{
                adapter=characterAdapter
            }
        }
    }
}