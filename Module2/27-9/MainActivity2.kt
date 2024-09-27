package com.example.componentex

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {

    lateinit var linearLayout: LinearLayout
    lateinit var txt1:TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        linearLayout = LinearLayout(this)

        txt1 = TextView(this)
        txt1.setText("Tops Tech")

        var width = LinearLayout.LayoutParams.MATCH_PARENT
        var height = LinearLayout.LayoutParams.WRAP_CONTENT
        txt1.width=200
        txt1.height=200

        linearLayout.addView(txt1)

        setContentView(linearLayout)



        //enableEdgeToEdge()
       // setContentView(R.layout.activity_main2)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}