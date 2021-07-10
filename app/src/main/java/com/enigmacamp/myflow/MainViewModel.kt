package com.enigmacamp.myflow

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
//    val listNamedLiveData =
//        mainRepository.getNameWithMaxLength(3)
//            .catch { Log.d("MainActivityViewModel", "Error") }
//            .asLiveData()

//    Cara panjang
//    private var _listNameLiveData = MutableLiveData<String>()
//    val listNamedLiveData: LiveData<String>
//        get() = _listNameLiveData
//
//    init {
//        viewModelScope.launch {
//            mainRepository.getNameWithMaxLength(3)
//                .catch {
//                    Log.d("MainActivityViewModel", "Error")
//                }.collect {
//                    _listNameLiveData.postValue(it)
//                }
//        }
//    }

    fun listNamedLiveData(maxLength: Int) =
        mainRepository.names.filter { name -> name.length <= maxLength }
            .catch { Log.d("MainActivityViewModel", "Error") }.asLiveData()
}