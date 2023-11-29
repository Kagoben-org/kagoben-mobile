package com.example.kagoben_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kagoben_mobile.features.daftarBelanja.daftarBelanja
import com.example.kagoben_mobile.features.home.home
import com.example.kagoben_mobile.features.home.newRecord
import com.example.kagoben_mobile.features.keranjangBelanja.keranjangBelanja
import com.example.kagoben_mobile.features.splashScreene.splashScreen
import com.example.kagoben_mobile.ui.theme.KagobenmobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            splashScreen()
//            Signin()
//            Signup()
//            home()
            daftarBelanja()
//            newRecord()
//            keranjangBelanja()
            }
        }
    }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KagobenmobileTheme {
        Greeting("Android")
    }
}