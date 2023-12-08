package com.example.kagoben_mobile.presentation.features.Signup

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.kagoben_mobile.R
import com.example.kagoben_mobile.data.PreferencesManager
import com.example.kagoben_mobile.navigation.Screen
import com.example.kagoben_mobile.presentation.component.Loading
import dagger.hilt.android.lifecycle.HiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Signup(
    navController: NavController,
    signUpViewModel: SignUpViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val preferencesManager = PreferencesManager(context)

    var localViewModel = signUpViewModel.state.collectAsState().value
    LaunchedEffect(localViewModel) {
        if (localViewModel is SignUpUiState.Error) {
            Toast.makeText(context, "Make sure all of the field filled", Toast.LENGTH_SHORT).show()
        }
    }
    when (localViewModel) {
        is SignUpUiState.Loading -> Loading()
        is SignUpUiState.Success -> navController.navigate(Screen.SignIn.route)
        else -> {}
    }

    var email: String by remember { mutableStateOf("") }
    var no_telp: String by remember { mutableStateOf("") }
    var usia: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }
    var username: String by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painterResource(R.drawable.sign_in_background),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(20.dp))
                .height(610.dp)
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
                text = "Sign Up",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp

            )
            Text(
                modifier = Modifier
                    .padding(end = 240.dp),
                text = "Email",
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp),
                value = email,
                onValueChange = { email = it },
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
                text = "Username"
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(
                        top = 20.dp,
                        bottom = 20.dp
                    ),
                value = username,
                onValueChange = { username = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White,
                    disabledTextColor = Color.Black,
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(.2f)
                ) {
                    Text(text = "Usia")
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(top = 5.dp),
                        value = usia,
                        onValueChange = { usia = it },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            disabledTextColor = Color.Black,
                            focusedBorderColor = Color.Black,
                            unfocusedBorderColor = Color.Black
                        ),

                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth(.7f)
                        .padding(start = 10.dp)
                ) {
                    Text(text = "No. Telepon")
                    OutlinedTextField(
                        modifier = Modifier
                            .padding(top = 5.dp),
                        value = no_telp,
                        onValueChange = { no_telp = it },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            containerColor = Color.White,
                            disabledTextColor = Color.Black,
                            focusedBorderColor = Color.Black,
                            unfocusedBorderColor = Color.Black
                        ),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    )
                }
            }
            Column {
                Text(
                    modifier = Modifier
                        .padding(end = 220.dp, top = 10.dp),
                    text = "Password"
                )
                OutlinedTextField(
                    modifier = Modifier
                        .padding(
                            top = 5.dp,
                            bottom = 20.dp
                        ),
                    value = password,
                    onValueChange = { password = it },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        containerColor = Color.White,
                        disabledTextColor = Color.Black,
                        focusedBorderColor = Color.Black,
                        unfocusedBorderColor = Color.Black
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )
            }
            Button(
                onClick = {
                    signUpViewModel.register(
                        email,
                        username,
                        usia,
                        noTelepon = no_telp,
                        password
                    )
                },
                modifier = Modifier
                    .width(282.dp)
                    .padding(top = 30.dp),
                shape = RoundedCornerShape(size = 4.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFD7DFE9)
                )
            ) {
                Text(
                    text = "Sign Up",
                    fontSize = 14.sp,
                    color = Color(0xFFF5E718D)
                )
            }

        }
    }
}