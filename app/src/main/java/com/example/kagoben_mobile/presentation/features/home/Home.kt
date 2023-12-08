package com.example.kagoben_mobile.presentation.features.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.kagoben_mobile.R
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import com.example.kagoben_mobile.model.KeranjangRespons
import com.example.kagoben_mobile.navigation.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    var localViewModel = viewModel.state.collectAsState().value

    var listKeranjang: KeranjangRespons = KeranjangRespons()

    when (localViewModel) {
        is HomeUiState.LogedOut -> navController.navigate(Screen.SignIn.route)
        is HomeUiState.Success -> {
            listKeranjang = localViewModel.keranjangs
            Log.i("data",listKeranjang.toString())
        }

        else -> {}
    }
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar() {
                    Row(
                        modifier = Modifier
                            .background(
                                Color.White
                            )
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Dialog()
                    }
                }
            },
            topBar = {
                NavigationBar {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .background(Color.White),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Daftar Belanja",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.sign_out_alt_solid),
                                contentDescription = "Logout",
                                modifier = Modifier
                                    .size(150.dp)
                                    .padding(start = 120.dp)
                                    .clickable { viewModel.logout() }
                            )
                        }
                        Row(
                            modifier = Modifier
                                .width(300.dp)
                                .height(10.dp)
                                .background(Color.White),
                        ) {}
                        Row(
                            modifier = Modifier
                                .width(360.dp)
                                .height(10.dp)
                                .background(Color(0xFFC7D66D), shape = RoundedCornerShape(20.dp)),
                        ) {

                        }
                    }
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
            ) {
                KegiatanBelanjaLazyColumn(listKeranjang, navController)
            }
        }
    }
}

@Composable
private fun keranjangBelanjaCard(
    namaKegiatanBelanja: String,
    tanggalKegiatanBelanja: String,
    hargaBelanja: String?,
    onClick:() ->Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentWidth(Alignment.CenterHorizontally)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .background(
                    color = Color(0xFFFDCEAB2),
                    shape = RoundedCornerShape(20.dp)
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Column(Modifier.padding(20.dp)) {
                Text(
                    text = namaKegiatanBelanja,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 10.dp)
                )
                Row {
                    Text(
                        text = tanggalKegiatanBelanja.split("T")[0],
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "IDR" + (hargaBelanja ?: "0"),
                        fontSize = 14.sp
                    )
                }
            }
            Image(
                painterResource(R.drawable.icon_pencil),
                contentDescription = "icon_pencil",
                modifier = Modifier
                    .padding(end = 30.dp)
                    .size(20.dp)
                    .clickable { onClick()}
            )
        }
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
private fun KegiatanBelanjaLazyColumn(
    listKeranjang: KeranjangRespons,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(listKeranjang.data.size) { index ->
            keranjangBelanjaCard(
                namaKegiatanBelanja = listKeranjang.data[index].nama,
                tanggalKegiatanBelanja = listKeranjang.data[index].tanggal,
                hargaBelanja = listKeranjang.data[index].total,
                onClick = {navController.navigate(Screen.DaftarBelanja.withArgs( listKeranjang.data[index].id.toString()))}
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dialog(viewModel: HomeViewModel = hiltViewModel()) {
    Column {
        var openDialog by remember { mutableStateOf(false) }
        var kategoriName: String by remember { mutableStateOf("") }

        Button(
            onClick = { openDialog = true },
            modifier = Modifier
                .width(190.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFFC7D66D))
        ) {
            Text(
                text = "New Record",
                color = Color.Black
            )
        }
        if (openDialog) {
            AlertDialog(
                onDismissRequest = { openDialog = false },
                text = {
                    OutlinedTextField(
                        value = kategoriName, onValueChange = { kategoriName = it },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.White,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent

                        )
                    )
                },
                confirmButton = {
                    Button(
                        onClick = {
                            openDialog = false
                            viewModel.createkeranjang(kategoriName)
                            kategoriName = ""
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC7D66D))
                    ) {
                        Text(text = "Submit")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            openDialog = false
                            kategoriName = ""
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC7D66D))
                    ) {
                        Text(text = "Cancel")
                    }
                }
            )
        }
    }
}

