package com.cheezycode.testingcoroutines

import kotlinx.coroutines.*

class Util(val dispatcher: CoroutineDispatcher) {

    suspend fun getUserName(): String {
        delay(10000)
        return "CheezyCode"
    }

    suspend fun getUser(): String {
        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
        }
        return "User - CheezyCode"
    }

    suspend fun getAddress(): String{
        withContext(dispatcher){
            delay(5000)
        }
        return "Address"
    }

    var globalArg = false
    fun getAddressDetail() {
        CoroutineScope(dispatcher).launch {
            globalArg = true
        }
    }
}