package com.example.kagoben_mobile.presentation.features.Signup

import com.example.kagoben_mobile.model.MemberRegister

sealed interface SignUpUiState{
    data class Success(val user: MemberRegister): SignUpUiState
    object Error: SignUpUiState
    object idle: SignUpUiState
    object Loading: SignUpUiState
}