package com.example.kagoben_mobile.navigation

sealed class Screen(val route: String) {
    object DaftarBelanja : Screen("daftar_belanja")
    object Home: Screen("home")
    object KeranjangBelanja: Screen("keranjang_belanja")
    object SignIn: Screen("signin")
    object SignUp : Screen("signup")
    object Splash: Screen("splash")

    fun withArgs(vararg args: String): String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}