package com.example.m5_hw2

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hw2.databinding.ItemCharacterBinding
import com.example.m5_hw2.Models.Character

class CharacterAdapter() : PagedListAdapter<Character, CharacterAdapter.CharacterViewHolder>(DIFF_CALLBACK) {
    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character: Character? = getItem(position)
        holder.bindTo(character)
    }

    class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bindTo(character:Character?){
                binding.nameTxt.text=character?.name
                binding.img.text=character?.image
            }

    }

    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(
                oldConcert: Character,
                newConcert: Character
            ) = oldConcert.id == newConcert.id

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldConcert: Character,
                newConcert: Character
            ) = oldConcert == newConcert
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding=ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterViewHolder(binding)
    }
}