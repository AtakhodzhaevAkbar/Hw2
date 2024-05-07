package com.example.m5_hw2.ViewModels


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.m5_hw2.data.local.entities.History
import com.example.m5_hw2.data.network.Models.LoveModel
import com.example.m5_hw2.data.repository.LoveRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val loveRepository: LoveRepository,
    application: Application
) : AndroidViewModel(application) {

    private val _historyList = MutableLiveData<List<History>>()
    val historyList: LiveData<List<History>> get() = _historyList

    private val _lovePercentage = MutableLiveData<LoveModel?>()
    val lovePercentage: LiveData<LoveModel?> get() = _lovePercentage

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    init {
        viewModelScope.launch {
            _historyList.value = loveRepository.getAllHistory()
        }
    }

    fun deleteHistory(historyId: Int) {
        viewModelScope.launch {
            loveRepository.deleteHistory(historyId)
        }
    }

    fun getLovePercentage(firstName: String, secondName: String, lifecycleOwner: LifecycleOwner): LiveData<LoveModel?> {
        _loading.value = true
        val lovePercentageLiveData = MutableLiveData<LoveModel?>()
        loveRepository.getLovePercentage(firstName, secondName).observe(lifecycleOwner) { loveModel ->
            _lovePercentage.value = loveModel
            _loading.value = false
            lovePercentageLiveData.value = loveModel
        }
        return lovePercentageLiveData
    }
}