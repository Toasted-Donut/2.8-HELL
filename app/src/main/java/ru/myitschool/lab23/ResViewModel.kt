package ru.myitschool.lab23

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import java.math.BigDecimal

class ResViewModel: ViewModel() {
    val res = MediatorLiveData<BigDecimal>()
}