package com.example.kagoben_mobile.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun Loading() {
    Box()
    {
        Row (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = "https://freesvg.org/img/1544764567.png",
                contentDescription = "loading",
            )
        }
    }
}