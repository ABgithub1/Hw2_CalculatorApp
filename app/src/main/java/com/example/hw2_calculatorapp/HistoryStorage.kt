package com.example.hw2_calculatorapp

object HistoryStorage {
    val historyList = mutableListOf<String>()

    fun addToHistory(string: String){
        historyList.add(string)
    }
}