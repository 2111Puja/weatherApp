package com.example.weatherapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.concurrent.locks.Condition
import kotlin.math.max

class activity_main_menu : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main_menu)
        val editTextDay = findViewById<TextView>(R.id.editTextDay)
        val editTextMinTemp = findViewById<TextView>(R.id.editTextMinTemp)
        val editTextMaxTemp = findViewById<TextView>(R.id.editTextMaxTemp)
        val editTextCondition = findViewById<TextView>(R.id.editTextCondition)

        // Initialise them
        var i: Int = 0 //stores number of entries in array
        var display: String = "" //display blank first
        val maxEntries = 7 //only allow 8 array entries

        var averageMinTemp: Int = 0
        var averageMaxTemp: Int = 0
        var displayWeekAverage: String = ""

        //Create arrays
        val day = Array(maxEntries) { "" }
        var MinTemp = Array(maxEntries) { "" }
        var MaxTemp = Array(maxEntries) { 0 }
        val condition = Array(maxEntries) { "" }

        val buttonDetails: Button = findViewById<Button>(R.id.buttonDetails)
        val buttonClear: Button = findViewById<Button>(R.id.buttonClear)
        val buttonExit: Button = findViewById<Button>(R.id.buttonExit)

        buttonDetails.setOnClickListener {
            //check if there's enough entries
            if (i < maxEntries) {
                //convert to display types
                day[i] = editTextDay.text.toString()
                MinTemp[i] =
                    (editTextMinTemp.text.toString().toIntOrNull()
                        ?: 0).toString() // 0 is for error checking
                MaxTemp[i] =
                    editTextMaxTemp.text.toString().toIntOrNull() ?: 0 // 0 is for error checking
                editTextCondition[i] = editTextCondition.text.toString()
                i++ //increment entry number

                Toast.makeText(this, "Entry added", Toast.LENGTH_LONG).show()
                }else{
                 Toast.makeText(this, "Maximum entries added", Toast.LENGTH_SHORT).show()
            }
        }

        //Clear the text views
        buttonClear.setOnClickListener {
            editTextDay.text = ""
            editTextMinTemp.text = ""
            editTextMaxTemp.text = ""
            editTextCondition.text = ""
        }

        //Button to navigate to Details View
        buttonDetails.setOnClickListener {
            display = ""

            for (counter in 0 until 1 ) {
                display += "Day: ${day[counter]}\nMinTemp: ${MinTemp[counter]}\nMaxTemp: ${MaxTemp[counter]}\nConditions: ${editTextCondition}\n\n"
                MinTemp += MinTemp[counter]
                MaxTemp += MaxTemp[counter]
                var also = MaxTemp[counter].toString().also { displayWeekAverage = it }
            }

            averageMaxTemp /= i
            averageMinTemp /= i

            displayWeekAverage =
                "Average Temperature: ${displayWeekAverage}\nAverage Temperature: ${displayWeekAverage}\n\n"

            // Pass the data to DetailedViewsActivity and start the activity
            val intent = Intent(this, activity_detail_views::class.java)
            intent.putExtra("DISPLAY_DATA", display)
            //intent.putExtra("DISPLAY_DATA_AVG", displayAverage)
            startActivity(intent)
        }
    }
}

private operator fun TextView.set(i: Int, value: String) {

}
