package com.example.kagoben_mobile.presentation.features.home

import com.example.kagoben_mobile.model.KeranjangRespons

sealed interface HomeUiState{
    data class Success(val keranjangs: KeranjangRespons): HomeUiState
    object Error: HomeUiState
    object Loading: HomeUiState
    object LogedOut: HomeUiState
}