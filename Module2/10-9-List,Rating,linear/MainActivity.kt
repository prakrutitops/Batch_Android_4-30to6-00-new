package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.RatingBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), RatingBar.OnRatingBarChangeListener {
    lateinit var rating:RatingBar
    lateinit var rating2:RatingBar
    lateinit var rating3:RatingBar
    lateinit var rating4:RatingBar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rating = findViewById(R.id.rate)
        rating.setOnRatingBarChangeListener(this)
//       rating.setOnRatingBarChangeListener(object :RatingBar.OnRatingBarChangeListener{
//           override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean)
//           {
//               Toast.makeText(applicationContext, "You Got : "+ ratingBar!!.rating, Toast.LENGTH_SHORT).show()
//           }
//       })
//
//        rating2.setOnRatingBarChangeListener(object:RatingBar.OnRatingBarChangeListener{
//            override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
//                TODO("Not yet implemented")
//            }
//        })

    }

    override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean)
    {
        Toast.makeText(applicationContext, ""+ ratingBar!!.rating, Toast.LENGTH_SHORT).show()
    }


}