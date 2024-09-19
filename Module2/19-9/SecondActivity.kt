package com.example.customlistex

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var i = intent
        var pos = i.getStringExtra("pos")

       var pos2 = pos!!.toInt()

        if(pos2==0)
        {
            //Toast.makeText(applicationContext, "Apple", Toast.LENGTH_SHORT).show()
            //list.get()


        }
        if(pos2==1)
        {
            Toast.makeText(applicationContext, "Strawberry", Toast.LENGTH_SHORT).show()

        }
        if(pos2==2)
        {
            Toast.makeText(applicationContext, "watermelon", Toast.LENGTH_SHORT).show()

        }
    }
}