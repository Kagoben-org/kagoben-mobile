package com.example.kagoben_mobile.model

data class MemberRegister(val email:String, val username:String, val token:String)
data class MemberRegisterResponse(val data: MemberRegister)
data class MemberLogin(val token: String)
data class MemberLoginResponse(val data: MemberLogin)
