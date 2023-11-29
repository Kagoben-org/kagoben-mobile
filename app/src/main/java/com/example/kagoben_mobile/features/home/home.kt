package com.example.kagoben_mobile.features.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kagoben_mobile.R
import com.example.kagoben_mobile.features.home.DataDummy.dataDummy


data class kegiatanBelanja(
    val id: String,
    val nama: String,
    val date: String,
    val total: String
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun home() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar(

                ) {
                    Row(
                        modifier = Modifier
                            .background(
                                Color.White
                            )
                            .fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .width(190.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFFC7D66D))
                        ) {
                            Text(
                                text = "New Record",
                                color = Color.Black
                            )
                        }
                    }
                }
            },
            topBar = {
                NavigationBar {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column {
                            Text(
                                text = "Daftar Belanja",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Row(
                            modifier = Modifier
                                .width(300.dp)
                                .height(10.dp)
                                .background(Color.White),
                        ) {

                        }
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
                kegiatanBelanjaLazyColumn()
            }
        }
    }
}

@Composable
private fun keranjangBelanjaCard(
    namaKegiatanBelanja: String,
    tanggalKegiatanBelanja: String,
    hargaBelanja: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentWidth(Alignment.CenterHorizontally)
    ) {

        Column(
            modifier = Modifier
                .width(380.dp)
                .background(
                    color = Color(0xFFFDCEAB2),
                    shape = RoundedCornerShape(20.dp)
                )
        ) {
            Text(
                text = namaKegiatanBelanja,
                fontSize = 14.sp,
                modifier = modifier
                    .padding(
                        top = 10.dp,
                        start = 15.dp
                    ),
                fontWeight = FontWeight.Bold
            )
            Image(
                painterResource(R.drawable.__icon__pencil_),
                contentDescription = null,
                modifier = Modifier
                    .graphicsLayer {
                        translationX = 1150F
                        translationY = 25F
                        scaleX = 1.4F
                        scaleY = 1.4F
                    }
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = tanggalKegiatanBelanja,
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = hargaBelanja,
                    modifier = Modifier
                        .padding(16.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
    Spacer(
        modifier = Modifier
            .height(20.dp)
    )
}

@Composable
private fun kegiatanBelanjaLazyColumn(
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(DataDummy.dataDummy.size) { index ->
            keranjangBelanjaCard(
                namaKegiatanBelanja = dataDummy[index].nama,
                tanggalKegiatanBelanja = dataDummy[index].date,
                hargaBelanja = dataDummy[index].total
            )
        }
    }
}