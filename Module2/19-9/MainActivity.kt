package com.example.customlistex

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{

    lateinit var listView: GridView
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listView = findViewById(R.id.list)
        list = ArrayList()

        //value set
        list.add(Model(R.drawable.apple, "Apple", "100","Rajkot"))
        list.add(Model(R.drawable.strawberry, "Strawberry", "200","Baroda"))
        list.add(Model(R.drawable.watermelon, "Watermelon", "300","Surat"))



        var adapter = MyAdapter(applicationContext,list)
        listView.adapter=adapter

        listView.setOnItemClickListener {
          parent, view, position, id ->



//            if(position==0)
//            {
//                Toast.makeText(applicationContext, "Apple", Toast.LENGTH_SHORT).show()
//            }
//            if(position==1)
//            {
//                Toast.makeText(applicationContext, "Strawberry", Toast.LENGTH_SHORT).show()
//            }
//            if(position==2)
//            {
//                Toast.makeText(applicationContext, "Watermelon", Toast.LENGTH_SHORT).show()
//            }

        }
    }
}