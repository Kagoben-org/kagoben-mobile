package com.example.kagoben_mobile.presentation.features.Signin

import com.example.kagoben_mobile.model.MemberLogin

sealed interface SignInUiState{

    data class Success(val user:MemberLogin):SignInUiState
    object Error: SignInUiState
    object idle: SignInUiState
    object Loading: SignInUiState
}