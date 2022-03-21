package com.vnedomovnyi.moviecompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.vnedomovnyi.moviecompose.R

private val Poppins = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_medium, FontWeight.W500),
    Font(R.font.poppins_semibold, FontWeight.W600),
    Font(R.font.poppins_bold, FontWeight.W700),
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W700,
        color = Color.White,
        fontSize = 36.sp,
    ),
    h2 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W600,
        color = Color.White,
        fontSize = 18.sp,
    ),
    h3 = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W500,
        color = Color.White,
        fontSize = 12.sp,
    ),
    body1 = TextStyle(
        fontFamily = Poppins,
        color = Color.White,
        fontSize = 12.sp,
    ),
    button = TextStyle(
        fontFamily = Poppins,
        fontWeight = FontWeight.W600,
        color = Color.White,
        fontSize = 14.sp,
    ),
)