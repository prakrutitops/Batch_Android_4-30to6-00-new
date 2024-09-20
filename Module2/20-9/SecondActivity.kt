package com.example.customlistex

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity()
{

    lateinit var img:ImageView
    lateinit var txt1:TextView
    lateinit var txt2:TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        img= findViewById(R.id.img)
        txt1 = findViewById(R.id.txt1)
        txt2 = findViewById(R.id.txt2)



        var i = intent

        img.setImageResource( i.getIntExtra("i",101))
        txt1.setText(i.getStringExtra("n"))
        txt2.setText(i.getStringExtra("p"))

        var pos = i.getIntExtra("pos",102)





//        var i = intent
//        var pos = i.getIntExtra("pos",101)
//        var a = i.getStringExtra("a")
//        var a1 = i.getStringExtra("a1")
//        if(pos==0)
//        {
//            Toast.makeText(applicationContext, "Data1 "+a+" "+a1, Toast.LENGTH_SHORT).show()
//        }
//        if(pos==1)
//        {
//            Toast.makeText(applicationContext, "Data1 "+a+" "+a1, Toast.LENGTH_SHORT).show()
//
//        }
//        if(pos==2)
//        {
//            Toast.makeText(applicationContext, "Data1 "+a+" "+a1, Toast.LENGTH_SHORT).show()
//
//        }

//        if(pos.equals("0"))
//        {
//
//        }
//        if(pos.equals("1"))
//        {
//
//        }
//
//        if(pos.equals("2"))
//        {
//
//        }

       //var pos2 = pos!!.toInt()


    }
}