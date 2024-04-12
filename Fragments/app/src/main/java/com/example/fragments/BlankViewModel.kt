package com.example.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BlankViewModel : ViewModel() {
    private val _selectedValue = MutableLiveData<String>()
    val selectedValue: LiveData<String> get() = _selectedValue

    fun setSelectedValue(value: String) {
        _selectedValue.value = value
    }
}