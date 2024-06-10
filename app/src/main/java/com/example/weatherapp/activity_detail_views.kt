package com.example.weatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.ActionMenuView
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class activity_detail_views : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_views)

        val buttonMenu: Button = findViewById<Button>(R.id.buttonMenu)
        val textViewDetails = findViewById<TextView>(R.id.textViewDetails)
        val displayData = intent.getStringExtra("DISPLAY_DATA")
        textViewDetails.text = displayData

        //val displayWeeklyAvg = findViewById<TextView>(R.id.displayWeeklyAvg)
        //val displayAverage = intent.getStringExtra("DISPLAY_DATA_AVG")
        //displayWeeklyAvg.text = displayAverage

        buttonMenu.setOnClickListener{
            val intent = Intent(this, ActionMenuView::class.java)
            startActivity(intent)
        }
    }
}