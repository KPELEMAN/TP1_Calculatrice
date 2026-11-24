package com.example.tp1_calculatrice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow
import android.util.Log
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Retrouve les deux champs où l'utilisateur saisit les nombres
        val champPremierNombre =
            findViewById<android.widget.EditText>(R.id.etPremierNombre)
        val champDeuxiemeNombre =
            findViewById<android.widget.EditText>(R.id.etDeuxiemeNombre)

        // Retrouve les quatre boutons de calcul
        val boutonAddition =
            findViewById<android.widget.Button>(R.id.btnAddition)
        val boutonSoustraction =
            findViewById<android.widget.Button>(R.id.btnSoustraction)
        val boutonMultiplication =
            findViewById<android.widget.Button>(R.id.btnMultiplication)
        val boutonDivision =
            findViewById<android.widget.Button>(R.id.btnDivision)
        val boutonPuissance =
            findViewById<android.widget.Button>(R.id.btnPuissance)

        // Retrouve la zone qui affichera le résultat
        val zoneResultat = findViewById<android.widget.TextView>(R.id.tvResultat)
            boutonAddition.setOnClickListener {
                // Transforme le texte des champs en nombres
                val premier = champPremierNombre.text.toString().toDoubleOrNull()
                val deuxieme = champDeuxiemeNombre.text.toString().toDoubleOrNull()

                // Vérifie que les deux champs contiennent un nombre
                if (premier != null && deuxieme != null) {
                    val somme = premier + deuxieme
                    zoneResultat.text = "Résultat : $somme"
                } else {
                    // Affiche un petit message si un champ est vide
                    android.widget.Toast.makeText(
                        this,
                        "Saisis les deux nombres.",
                        android.widget.Toast.LENGTH_SHORT
                    ).show()
                }
            }
        // Lance la soustraction quand l'utilisateur appuie sur le bouton
        boutonSoustraction.setOnClickListener {
            // Transforme le texte des champs en nombres
            val premier = champPremierNombre.text.toString().toDoubleOrNull()
            val deuxieme = champDeuxiemeNombre.text.toString().toDoubleOrNull()

            // Vérifie que les deux champs contiennent un nombre
            if (premier != null && deuxieme != null) {
                val difference = premier - deuxieme
                zoneResultat.text = "Résultat : $difference"
            } else {
                // Avertit l'utilisateur si un champ est vide
                android.widget.Toast.makeText(
                    this,
                    "Saisis les deux nombres.",
                    android.widget.Toast.LENGTH_SHORT
                ).show()
            }
        }
        // Lance la multiplication quand l'utilisateur appuie sur le bouton
        boutonMultiplication.setOnClickListener {
            // Transforme le texte des champs en nombres
            val premier = champPremierNombre.text.toString().toDoubleOrNull()
            val deuxieme = champDeuxiemeNombre.text.toString().toDoubleOrNull()

            // Vérifie que les deux champs contiennent un nombre
            if (premier != null && deuxieme != null) {
                val produit = premier * deuxieme
                zoneResultat.text = "Résultat : $produit"
            } else {
                // Avertit l'utilisateur si un champ est vide
                android.widget.Toast.makeText(
                    this,
                    "Saisis les deux nombres.",
                    android.widget.Toast.LENGTH_SHORT
                ).show()
            }
        }
        // Lance la division quand l'utilisateur appuie sur le bouton
        boutonDivision.setOnClickListener {
            val premier = champPremierNombre.text.toString().toDoubleOrNull()
            val deuxieme = champDeuxiemeNombre.text.toString().toDoubleOrNull()

            if (premier != null && deuxieme != null) {
                Log.d("Calculatrice", "Division demandée : $premier / $deuxieme")

                if (deuxieme == 0.0) {
                    Log.e("Calculatrice", "Dénominateur nul : division refusée")
                    android.widget.Toast.makeText(
                        this,
                        "La division par zéro est impossible.",
                        android.widget.Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val quotient = diviser(premier, deuxieme)
                    zoneResultat.text = "Résultat : $quotient"
                }
            } else {
                android.widget.Toast.makeText(
                    this,
                    "Saisis les deux nombres.",
                    android.widget.Toast.LENGTH_SHORT
                ).show()
            }
        }
        boutonPuissance.setOnClickListener {
            val premier = champPremierNombre.text.toString().toDoubleOrNull()
            val deuxieme = champDeuxiemeNombre.text.toString().toDoubleOrNull()

            if (premier != null && deuxieme != null) {
                val resultatPuissance = premier.pow(deuxieme)

                if (resultatPuissance.isFinite()) {
                    zoneResultat.text = "Résultat : $resultatPuissance"
                } else {
                    android.widget.Toast.makeText(
                        this,
                        "Cette puissance ne donne pas de résultat réel fini.",
                        android.widget.Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                android.widget.Toast.makeText(
                    this,
                    "Saisis les deux nombres.",
                    android.widget.Toast.LENGTH_SHORT
                ).show()
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

}