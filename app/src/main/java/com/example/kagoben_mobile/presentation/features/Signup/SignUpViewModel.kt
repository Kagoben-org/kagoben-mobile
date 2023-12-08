package com.example.kagoben_mobile.presentation.features.Signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kagoben_mobile.data.PreferencesManager
import com.example.kagoben_mobile.model.service.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
) : ViewModel() {

    private val mutableState = MutableStateFlow<SignUpUiState>(SignUpUiState.Loading)
    val state = mutableState.asStateFlow()
    fun register(
        email: String,
        username: String,
        usia: String,
        noTelepon: String,
        password: String
    ) {
        viewModelScope.launch {
            try {
                val res = ApiService.retrofitService.register(email, username,usia, noTelepon, password)
                mutableState.value = SignUpUiState.Success(res.data)
            } catch (e: IOException) {
                mutableState.value = SignUpUiState.Error
            } catch (e: HttpException) {
                mutableState.value = SignUpUiState.Error
            } catch (e: Error) {
                mutableState.value = SignUpUiState.Error
            }
        }
    }
}