package com.example.kagoben_mobile.features.keranjangBelanja

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kagoben_mobile.R
import com.example.kagoben_mobile.features.keranjangBelanja.dataDummyKeranjang.dataDummy


data class BasketItem(
    val id: String,
    val name: String,
    val price: Long,
    val quantity: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun keranjangBelanja() {
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
                                text = "Checkout",
                                color = Color.Black,
                            )
                        }
                    }
                }
            },
            topBar = {
                NavigationBar {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .weight(6f),
                        color = Color.Yellow
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Surface(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .weight(5f)
                            ) {
                                Text(
                                    text = "Rincian Belanja",
                                    modifier = Modifier
                                        .padding(
                                            start = 20.dp,
                                            top = 30.dp
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
                                        .padding(start = 20.dp)
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
                            modifier = Modifier
                                .fillMaxSize()
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
                                    modifier = Modifier
                                        .padding(
                                            start = 0.dp,
                                            top = 30.dp
                                        ),
                                )
                            }
                            Surface(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(2f)
                                    .fillMaxHeight()
                            ) {
                                Text(text = "$2.100.000")
                            }
                        }
                    }
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                keranjangBelanjaLazyColumn()
            }
        }
    }
}

@Composable
fun BasketCard(
    basketItem: BasketItem,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(

    ) {
        Row(
        ) {
            Surface(
                modifier = Modifier
                    .weight(3f)
                    .padding(top = 15.dp, bottom = 15.dp, start = 20.dp)
            ) {
                Column(

                ) {
                    Surface(
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth()
                            .padding(top = 15.dp, bottom = 15.dp)
                    ) {
                        Text(
                            text = basketItem.name,
                            fontSize = 16.sp
                        )
                    }

                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp, bottom = 15.dp)
                    ) {
                        Text(text = "$" + basketItem.price.toString())
                    }
                }
            }

            Surface(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 15.dp, bottom = 15.dp, end = 20.dp),
            ) {
                Column(

                ) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(top = 15.dp, bottom = 15.dp),
                        color = Color.Green
                    ) {
                        Text(text = "Gambar")
                    }

                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 15.dp, bottom = 15.dp)
                    ) {
                        Row() {
                            Surface(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_remove_circle_24),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .clickable { }
                                )
                            }
                            Surface(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f)
                            ) {
                                Text(
                                    text = basketItem.quantity.toString(),
                                    textAlign = TextAlign.Center
                                )
                            }
                            Surface(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.baseline_add_circle_24),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .clickable { })
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
private fun keranjangBelanjaLazyColumn(
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier) {
        items(dataDummyKeranjang.dataDummy.size) { index ->
            BasketCard(basketItem = dataDummy[index], onClick = { /*TODO*/ })
        }
    }
}

