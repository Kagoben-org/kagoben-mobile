package com.example.kagoben_mobile.presentation.features.home

import android.icu.text.SimpleDateFormat
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kagoben_mobile.data.PreferencesManager
import com.example.kagoben_mobile.model.Keranjang
import com.example.kagoben_mobile.model.KeranjangReq
import com.example.kagoben_mobile.model.service.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.sql.Date
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
) : ViewModel() {

    val token = preferencesManager.getData("token", "")
    private val mutableState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val state = mutableState.asStateFlow()

    init {
        getAllKeranjang()
    }

    fun getAllKeranjang() {
        viewModelScope.launch {
            try {
                val res = ApiService.keranjangService.getAllKeranjang("Bearer $token")
                mutableState.value = HomeUiState.Success(res)
            } catch (e: Error) {
                mutableState.value= HomeUiState.Error
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            try {
                preferencesManager.saveData("token", "")
                mutableState.value = HomeUiState.LogedOut
            } catch (e: Error) {
                mutableState.value= HomeUiState.Error
            }
        }
    }

    fun createkeranjang(kategoriname:String) {
        val yourmilliseconds = System.currentTimeMillis()
        val sdf = SimpleDateFormat("MMM dd,yyyy HH:mm")
        val resultdate = Date(yourmilliseconds)
        val req = KeranjangReq(
            nama = kategoriname,
            tanggal = resultdate.toString(),
            total = null
        )
        viewModelScope.launch {
            try {
                val res = ApiService.keranjangService.createKeranjang("Bearer $token",req)
                val listKeranjang = ApiService.keranjangService.getAllKeranjang("Bearer $token")
                mutableState.value =  HomeUiState.Success(listKeranjang)
            } catch (e: Error) {
                HomeUiState.Error
            }
        }
    }
}