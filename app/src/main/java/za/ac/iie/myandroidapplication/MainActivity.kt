//Khanya Ndamage
//st10488713@rcconnect.edu.za

package.com.example.myplaylistmanager

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import za.ac.iie.myandroidapplication.DetailViewActivity
import za.ac.iie.myandroidapplication.R

class MainActivity : AppCompatActivity() {

    companion object {
        val titles = ArrayList<String>()
        val artistnames = ArrayList<String>()
        val ratings = ArrayList<Int>()
        val comments = ArrayList<String>()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputTitle = findViewById<EditText>(R.id.input_Title)
        val inputArtist = findViewById<EditText>(R.id.input_Artist)
        val inputRating = findViewById<EditText>(R.id.input_rating)
        val inputComments = findViewById<EditText>(R.id.input_comment)

        val btnAdd = findViewById<Button>(R.id.btnadd)
        val btnView = findViewById<Button>(R.id.btnview)
        val btnExit = findViewById<Button>(R.id.btnexit)



         btnAdd.setOnClickListener {
            try {
                val title = inputTitle.text.toString().trim()
                val Artist = inputArtist.text.toString().trim()
                val Rating = inputRating.text.toString().trim()
                val comments = inputComments.text.strings.toString().trim()


                if (title.isEmpty() || Artist.isEmpty() || Rating.isEmpty() || comments.isEmpty()) {
                    Toast.makeText(this, "please fill in all fileds.", Toast.LENGTH_SHORT).show()
                } else {
                    val rating = Rating.toIntOrNull()
                    if (rating == null || rating !in 1 ..5) {
                        Toast.makeText(
                            this,
                            "Rating must be a number between 1 and 5.",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        titles.add(title)
                        artistnames.add(Artist)
                        ratings.add(rating)
                        comments.add(comments)

                        Toast.makeText(this, "song added successfully!", Toast.LENGTH_SHORT).show()
                            //clear inputs
                        inputTitle.text.clear()
                        inputArtist.text.clear()
                        inputRating.text.clear()
                        inputComments.text.clear()
                    }
                }
            }

             btnView.setOnClickListener {
                 val intent = Intent(this, DetailViewActivity::class.java)
                 startActivity(intent)
             }

             btnExit.setOnClickListener {
                 finishAffinity()
                    }

                }


            }

            }
        }


        }