package com.example.tp1_calculatrice

internal fun diviser(a: Double, b: Double): Double {
    require(b != 0.0) { "Dénominateur nul" }
    return a / b
}