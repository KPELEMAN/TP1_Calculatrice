package com.example.tp1_calculatrice

import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

class CalculatriceTest {
    @Test
    fun divisionNormaleDonneLeBonResultat() {
        assertEquals(5.0, diviser(10.0, 2.0), 0.0)
    }

    @Test
    fun divisionParZeroEstRefusee() {
        try {
            diviser(10.0, 0.0)
            fail("La division par zéro aurait dû être refusée.")
        } catch (e: IllegalArgumentException) {
            assertEquals("Dénominateur nul", e.message)
        }
    }
}