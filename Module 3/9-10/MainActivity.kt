package com.example.myapplication2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity()
{
    lateinit var f1:FloatingActionButton
    lateinit var listView: ListView
    lateinit var list:MutableList<String>

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

        f1 = findViewById(R.id.f1)

        listView = findViewById(R.id.list)
        list = ArrayList()

        list.add("Android")
        list.add("Java")
        list.add("php")
        list.add("Android")
        list.add("Java")
        list.add("php")
        list.add("Android")
        list.add("Java")
        list.add("php")
        list.add("Android")
        list.add("Java")
        list.add("php")
        list.add("Android")
        list.add("Java")
        list.add("php")
        list.add("Android")
        list.add("Java")
        list.add("php")
        list.add("Android")
        list.add("Java")
        list.add("php")
        list.add("Android")
        list.add("Java")
        list.add("php")
        list.add("Android")
        list.add("Java")
        list.add("php")
        list.add("Android")
        list.add("Java")
        list.add("php")
        list.add("Android")
        list.add("Java")
        list.add("php")
        list.add("Android")
        list.add("Java")
        list.add("php")
        list.add("Android")
        list.add("Java")
        list.add("php")
        list.add("Android")
        list.add("Java")
        list.add("php")
        list.add("Android")
        list.add("Java")
        list.add("php")

        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        listView.adapter=adapter

        f1.setOnClickListener {

            Toast.makeText(applicationContext, "Button Called", Toast.LENGTH_SHORT).show()
        }
    }
}