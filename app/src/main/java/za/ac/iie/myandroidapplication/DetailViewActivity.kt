package com.example.myplaylistmanager

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import za.ac.iie.myandroidapplication.R

class DetailViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailviewscreen)

        val songList = findViewById<TextView>(R.id.input_Title)
        val btnShowList = findViewById<Button>(R.id.btnshowlist
        val btnAverage = findViewById<button>(R.id.btnAverage)
        val btnBack = findViewById<Button>(R.id.btnback)
        val averageText = findViewById<TextView>(R.id.btnAverage)

        btnShowList.setOnClickListener {
            var display = ""
            for (i in MainActivity.titles.indices) {
                display += "${MainActivity.titles[i]} - ${MainActivity.artistnames[i]} (Rating: ${MainActivity.ratings[i]})\nComment: ${MainActivity.comments[i]}\n\n"
            }
            songList.text = display.ifEmpty { "No songs in playlist." }
        }


        btnAverage.setOnClickListener {
            val total = MainActivity.ratings.sum()
            val count = MainActivity.ratings.size

            val average = if (count > 0) total.toDouble() / count else 0.0
            averageText.text = "Average Rating: %.2f".format(average)
        }

        btnBack.setOnClickListener {
            finish()
        }
    }
}


