package com.example.kagoben_mobile.model

data class Keranjang(val id:Int,val nama:String, val tanggal:String, val total: String?)

data class KeranjangReq(val nama:String, val tanggal:String, val total: String?)

data class KeranjangRespons(val data: List<Keranjang> = emptyList())

