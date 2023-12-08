package com.example.kagoben_mobile.presentation.features.daftarBelanja

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kagoben_mobile.R
import com.example.kagoben_mobile.presentation.features.daftarBelanja.DataDummyDaftarBelanja.dataDummy

data class bahanDaftarBelanja(
    val id: String,
    val nama: String,
    val isChosen: Boolean
)

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DaftarBelanja(id: String, navController: NavController) {
    Scaffold(
        topBar = {
            NavigationBar() {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var value: String by remember { mutableStateOf("") }
                    TextField(
                        value = value,
                        onValueChange = { value = it },
                        modifier = Modifier
                            .padding(
                                top = 10.dp,
                                start = 30.dp,
                                end = 30.dp
                            )
                            .fillMaxWidth()
                            .clip(CircleShape)
                            .border(
                                width = 4.dp,
                                color = Color(0xFFDCEAB2),
                                CircleShape
                            ),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )
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
                    ) {}
                }
            }
        },
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
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .width(190.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFFC7D66D))
                    ) {
                        Text(
                            text = "Add to cart",
                            color = Color.Black
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            DaftarBelanjaLazyColumn()
        }
    }
}

@Composable
fun DaftarBelanjaCard(
    namaBahan: String,
    bahanIsChosen: Boolean
) {
    Column(
        modifier = Modifier
            .padding(top = 30.dp, bottom = 30.dp, start = 30.dp, end = 30.dp)
    ) {
        Row(

        ) {
            Text(
                text = namaBahan,
                modifier = Modifier
                    .weight(1f),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Image(
                painter = painterResource(id = R.drawable.baseline_do_disturb_24),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 13.dp)
            )
        }
        val checkedState = remember { mutableStateOf(bahanIsChosen) }
        Image(painter = painterResource(id = R.drawable.baseline_add_circle_24),
            contentDescription = null,
            modifier = Modifier
                .clickable {  }
                .align(Alignment.End)
                .padding(end = 12.dp, top = 10.dp))
    }
}

@Composable
fun DaftarBelanjaLazyColumn(
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(DataDummyDaftarBelanja.dataDummy.size) { index ->
            DaftarBelanjaCard(
                namaBahan = dataDummy[index].nama,
                bahanIsChosen = dataDummy[index].isChosen
            )
        }
    }
}
