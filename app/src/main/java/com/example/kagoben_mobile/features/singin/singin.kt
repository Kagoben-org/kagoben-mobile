package com.example.kagoben_mobile.features.singin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kagoben_mobile.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Signin(

) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painterResource(R.drawable.rectangle_4),
            contentDescription = "RectangleBG",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(20.dp))
                .height(450.dp)
                .width(350.dp)
                .clip(
                    RoundedCornerShape(
                        size = 20.dp
                    )
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .graphicsLayer {
                        translationY = -80F
                        translationX = -390F
                    },
                text = "Sign in",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp

            )
            Text(
                modifier = Modifier
                    .padding(end = 240.dp),
                text = "Email",
            )

            var value: String by remember { mutableStateOf("") }

            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp),
                value = value,
                onValueChange = { value = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White,
                    disabledTextColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                )

            )

            Text(
                modifier = Modifier
                    .padding(end = 220.dp),
                text = "Password"
            )

            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 20.dp),
                value = value,
                onValueChange = { value = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White,
                    disabledTextColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                )

            )
            Button(
                onClick = {},
                modifier = Modifier
                    .width(282.dp)
                    .padding(top = 30.dp),
                shape = RoundedCornerShape(size = 4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFD7DFE9)
                )
            ) {
                Text(
                    text = "Sign In",
                    fontSize = 14.sp,
                    color = Color(0xFFF5E718D)
                )
            }
            Text(
                text = "Doesnt Know What to coock right now? Join us",
                modifier = Modifier
                    .padding(top = 20.dp)
            )
        }
    }
}