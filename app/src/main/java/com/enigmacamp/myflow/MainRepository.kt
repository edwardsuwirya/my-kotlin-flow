package com.enigmacamp.myflow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

class MainRepository {
//    val names = listOf("Jody", "Steve", "Lance", "Joe").asFlow()
//
//
//    fun getNameWithMaxLength(maxLength: Int) = names.filter { name ->
//        name.length <= maxLength
//    }.onEach {
//        throw Exception("Test Exception")
//        println(it)
//    }.flowOn(Dispatchers.IO)

    val listName = listOf("Jody", "Steve", "Lance", "Joe")
    val names = flow {
        for (name in listName) {
            delay(1000)
            emit(name)
        }
    }
}