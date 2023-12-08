package com.example.kagoben_mobile.presentation.features.keranjangBelanja

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kagoben_mobile.R
import com.example.kagoben_mobile.presentation.features.keranjangBelanja.dataDummyKeranjang.dataDummy


data class BasketItem(
    val id: String, val name: String, val price: Long, val quantity: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun KeranjangBelanja(navController: NavController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Scaffold(bottomBar = {
            NavigationBar(
            ) {
                Row(
                    modifier = Modifier
                        .background(Color.White)
                        .fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {},
                        modifier = Modifier.width(190.dp),
                        colors = ButtonDefaults.buttonColors(Color(0xFFC7D66D))
                    ) {
                        Text(
                            text = "Checkout",
                            color = Color.Black,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }, topBar = {
            NavigationBar {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .weight(6f),
                    color = Color.Yellow
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Surface(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(5f)
                        ) {
                            Text(
                                text = "Rincian Belanja",
                                modifier = Modifier.padding(
                                    start = 20.dp, top = 20.dp
                                ),
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                textAlign = TextAlign.Start
                            )
                        }
                        Surface(
                            modifier = Modifier
                                .fillMaxSize()
                                .weight(2f)
                        ) {
                            Text(
                                text = "01-04-2023",
                                modifier = Modifier
                                    .padding(start = 20.dp, bottom = 5.dp),
                                fontSize = 15.sp,

                            )
                        }
                    }
                }
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f)
                        .fillMaxHeight(),
                    color = Color.Blue
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .weight(5f)
                        ) {
                            Text(
                                text = "Total",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier.padding(top = 20.dp),
                            )
                        }
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(2f)
                                .fillMaxHeight()
                        ) { Text(text = "$2.100.000", fontSize = 15.sp) }
                    }
                }
            }
        }) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                KeranjangBelanjaLazyColumn()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasketCard(
    basketItem: BasketItem, onClick: () -> Unit, modifier: Modifier = Modifier
) {
    var price: String by remember { mutableStateOf(basketItem.price.toString()) }
    var quantity: String by remember { mutableStateOf(basketItem.quantity.toString()) }
    Surface {
        Row {
            Surface(
                modifier = Modifier
                    .weight(3f)
                    .padding(top = 15.dp, bottom = 15.dp, start = 20.dp)
            ) {
                Column {
                    Text(
                        text = basketItem.name,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(top = 10.dp, bottom = 20.dp)
                    )
                    OutlinedTextField(
                        value = price,
                        onValueChange = { price = it },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = Color.Black,
                            focusedBorderColor = Color(0xFFC7D66D), // Custom focused border color
                            unfocusedBorderColor = Color(0xFFC7D66D)
                            // Custom unfocused border color
                        ),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .width(150.dp)
                            .height(50.dp)
                    )
                }
            }

            Surface(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 15.dp, bottom = 15.dp, end = 20.dp),
            ) {
                Column {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(top = 15.dp, bottom = 15.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_do_disturb_24),
                            contentDescription = null
                        )
                    }

                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 15.dp, bottom = 15.dp)
                    ) {
                        Row {
                            Surface(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f)
                            ) {
                                Image(painter = painterResource(id = R.drawable.baseline_remove_circle_24),
                                    contentDescription = null,
                                    modifier = Modifier.clickable { })
                            }
                            Surface(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f)
                            ) {
                                BasicTextField(
                                    value = quantity,
                                    onValueChange = { quantity = it },
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    maxLines = 2,
                                    textStyle = TextStyle.Default.copy(
                                        fontSize = 16.sp,
                                        textAlign = TextAlign.Center
                                    ),
                                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                                )
                            }
                            Surface(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f)
                            ) {
                                Image(painter = painterResource(id = R.drawable.baseline_add_circle_24),
                                    contentDescription = null,
                                    modifier = Modifier.clickable { })
                            }
                        }
                    }
                }
            }
        }
    }
    Row(
        modifier = Modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(Color(0xFFAEAEAE))
    ) {

    }
}

@Composable
private fun KeranjangBelanjaLazyColumn(
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(dataDummyKeranjang.dataDummy.size) { index ->
            BasketCard(basketItem = dataDummy[index], onClick = { /*TODO*/ })
        }
    }
}

