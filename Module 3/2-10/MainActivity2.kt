package com.example.sharedprefrenceex1

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity()
{
    lateinit var txt1:TextView
    lateinit var sharedPreferences: SharedPreferences
    lateinit var btn1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txt1 = findViewById(R.id.txt1)
        btn1 = findViewById(R.id.btn2)

        sharedPreferences = getSharedPreferences("tops", MODE_PRIVATE)

        txt1.setText("Welcome: "+sharedPreferences.getString("e1","Default Email"))

        btn1.setOnClickListener {

            sharedPreferences.edit().clear().commit()
            var i = Intent(applicationContext,MainActivity::class.java)
            startActivity(i)
            finish()

        }
    }
}