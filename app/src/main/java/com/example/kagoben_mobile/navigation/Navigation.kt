package com.example.kagoben_mobile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kagoben_mobile.presentation.features.Signin.Signin
import com.example.kagoben_mobile.presentation.features.Signup.Signup
import com.example.kagoben_mobile.presentation.features.daftarBelanja.DaftarBelanja
import com.example.kagoben_mobile.presentation.features.home.Home
import com.example.kagoben_mobile.presentation.features.keranjangBelanja.KeranjangBelanja
import com.example.kagoben_mobile.presentation.features.splashScreen.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.SignIn.route) {
            Signin(navController)
        }
        composable(route = Screen.SignUp.route) {
            Signup(navController)
        }
        composable(route = Screen.Home.route) {
            Home(navController)
        }
        composable(
            route = Screen.DaftarBelanja.route + "/{campaign_id}",
            arguments = listOf(
                navArgument("campaign_id"){
                    type = NavType.StringType
                    nullable = true
                }
            )
        ){entry ->
            entry.arguments!!.getString("campaign_id")
                ?.let { DaftarBelanja(id = it, navController) }
        }

//        composable(
//            route = Screen.CampaignDetail.route + "/{campaign_id}",
//            arguments = listOf(
//                navArgument("campaign_id"){
//                    type = NavType.StringType
//                    nullable = true
//                }
//            )
//        ){entry ->
//            entry.arguments!!.getString("campaign_id")
//                ?.let { CampaignDetail(id = it, navController) }
//        }
    }
}