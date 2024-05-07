package com.example.m5_hw2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw2.databinding.HistoryItemBinding
import com.example.m5_hw2.ViewModels.MainViewModel
import com.example.m5_hw2.data.local.entities.History

class HistoryAdapter(
    private val context: Context,
    private val mainViewModel: MainViewModel
) : ListAdapter<History, HistoryAdapter.HistoryViewHolder>(HistoryDiffCallback()) {

    inner class HistoryViewHolder(val binding: HistoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnLongClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val history = getItem(position)
                    showDeleteDialog(history.id)
                }
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HistoryItemBinding.inflate(inflater, parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val history = getItem(position)
        holder.binding.apply {
            firstName.text = history.firstName
            secondName.text = history.secondName
            percentage.text = history.percent
            root.setOnLongClickListener {
                val history = getItem(position)
                showDeleteDialog(history.id)
                true
            }
        }
    }

    private fun showDeleteDialog(historyId: Int) {
        AlertDialog.Builder(context)
            .setMessage("Are you sure you want to delete this history?")
            .setPositiveButton("Yes") { _, _ ->
                mainViewModel.deleteHistory(historyId)
            }
            .setNegativeButton("No", null)
            .show()
    }
}

class HistoryDiffCallback : DiffUtil.ItemCallback<History>() {
    override fun areItemsTheSame(oldItem: History, newItem: History): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: History, newItem: History): Boolean {
        return oldItem == newItem
    }
}
