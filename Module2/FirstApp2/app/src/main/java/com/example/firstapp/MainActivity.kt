package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{
    //declaration
    lateinit var b1:Button
    lateinit var txt1:TextView
    lateinit var txt2:TextView
    lateinit var txt3:TextView
    lateinit var txt4:TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //initialization
        b1 = findViewById(R.id.btn1)
        txt1 = findViewById(R.id.t1)
        txt2 = findViewById(R.id.t2)
        txt3 = findViewById(R.id.t3)
        txt4 = findViewById(R.id.t4)



        b1.setOnClickListener {

           Toast.makeText(applicationContext,"welcome to tops",Toast.LENGTH_LONG).show()
        }
        txt1.setOnClickListener {


        }
        txt2.setOnClickListener {
            Toast.makeText(applicationContext, "1", Toast.LENGTH_SHORT).show()
        }
        txt3.setOnClickListener {

            var i = Intent(applicationContext,MainActivity2::class.java)
            startActivity(i)
        }



    }
}