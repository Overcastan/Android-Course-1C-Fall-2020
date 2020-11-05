package com.github.overcastan.trainingproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToProfile = findViewById<Button>(R.id.toProfile)
        btnToProfile.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        val addresses : Array<String> = arrayOf("khmuro.av@phystech.edu")
        val ending : String = "\n\nSended from my new App"

        val btnSendEmail = findViewById<Button>(R.id.sendEmail)
        btnSendEmail.setOnClickListener {
            composeEmail(addresses, "Testing new Email feature", ending)
        }
    }

    private fun composeEmail(addresses: Array<String>, subject: String, ending : String) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "*/*"
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
            putExtra(Intent.EXTRA_TEXT, ending)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

}