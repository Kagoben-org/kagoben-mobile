package com.example.kagoben_mobile.lib

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun convertDateFormat(inputDate: String): String {
    // Parse input date
    val inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val date = LocalDate.parse(inputDate, inputFormatter)

    // Format the date to the desired output format
    val outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return date.format(outputFormatter)
}