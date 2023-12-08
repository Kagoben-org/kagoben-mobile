package com.example.kagoben_mobile.presentation.features.Signin

import android.util.Log
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
class SignInViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
): ViewModel(){

    private val mutableState = MutableStateFlow<SignInUiState>(SignInUiState.Loading)
    val state =mutableState.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                val res = ApiService.retrofitService.login(email, password)
                preferencesManager.saveData("token",res.data.token)
                mutableState.value = SignInUiState.Success(res.data)
            } catch (e: IOException) {
                mutableState.value = SignInUiState.Error
            } catch (e: HttpException) {
                mutableState.value = SignInUiState.Error
            }catch (e:Error){
                mutableState.value = SignInUiState.Error
            }
        }
    }
}