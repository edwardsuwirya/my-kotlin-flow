package com.enigmacamp.myflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        subscribe()
    }

    private fun initViewModel() {
        mainViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                val repository = MainRepository()
                return MainViewModel(repository) as T
            }

        }).get(MainViewModel::class.java)
    }

    private fun subscribe() {
        mainViewModel.listNamedLiveData(3).observe(this, {
            Log.d("MainActivity", "subscribe: $it")
        })
    }
}