package com.example.intentexample

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{

    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button

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

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)

        btn1.setOnClickListener {

                var i = Intent(applicationContext,MainActivity2::class.java)
                startActivity(i)


        }
        btn2.setOnClickListener {

            var url="https://play.google.com/store/apps/details?id=in.swiggy.android&hl=en-IN"
            var i = Intent(Intent.ACTION_VIEW)
            i.setData(Uri.parse(url))
            startActivity(i)


        }

        btn3.setOnClickListener {

            var url="8980073845"
            var i = Intent(Intent.ACTION_CALL)
            i.setData(Uri.parse("tel:"+url))
            startActivity(i)
        }
    }
}