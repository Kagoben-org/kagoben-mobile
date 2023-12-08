package com.example.kagoben_mobile.presentation.features.Signin

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.kagoben_mobile.R
import com.example.kagoben_mobile.data.PreferencesManager
import com.example.kagoben_mobile.navigation.Screen
import com.example.kagoben_mobile.presentation.component.Loading

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Signin(
    navController: NavController,
    viewModel: SignInViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val preferencesManager = PreferencesManager(context)

    var localViewModel = viewModel.state.collectAsState().value
    LaunchedEffect(localViewModel) {
        if(preferencesManager.getData("token","")!==""){
            navController.navigate(Screen.Home.route)
        }else {
            if (localViewModel is SignInUiState.Error) {
                Toast.makeText(context, "Username or Password is Wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }

    when (localViewModel) {
        is SignInUiState.Loading -> Loading()
        is SignInUiState.Success -> navController.navigate(Screen.Home.route)
        else -> {}
    }

    var email: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painterResource(R.drawable.sign_in_background),
            contentDescription = "background",
            contentScale = ContentScale.Crop,
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
                .background(
                    Color.White,
                    shape = RoundedCornerShape(20.dp)
                )
                .height(450.dp)
                .width(350.dp)
                .clip(RoundedCornerShape(size = 20.dp))
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Sign in",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                modifier = Modifier
                    .padding(end = 240.dp),
                text = "Email",
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp)
                    .fillMaxWidth(),
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
                text = "Password"
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth(),
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
            Button(onClick = {viewModel.login(email, password)},
                modifier = Modifier
                    .fillMaxWidth()
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
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "Doesn\'t Know What to coock right now?",
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = "Join us",
                    Modifier.clickable { navController.navigate(Screen.SignUp.route) },
                    color = Color(0xFF4AC9ff)
                )
            }
        }

    }
}