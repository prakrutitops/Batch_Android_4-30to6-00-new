package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListExActivity : AppCompatActivity()
{
    lateinit var listview:ListView
    lateinit var list:MutableList<String>
    lateinit var editText: EditText
    lateinit var btn:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_ex)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listview = findViewById(R.id.list)
        list = ArrayList()
        editText = findViewById(R.id.edt1)
        btn = findViewById(R.id.btn1)

        btn.setOnClickListener {

            Toast.makeText(applicationContext, "1", Toast.LENGTH_SHORT).show()
            var data = editText.text.toString()

            list.add(data)

        }


//        list.add("Android")
//        list.add("Java")
//        list.add("Php")
//        list.add("Ios")
//        list.add("Android")
//        list.add("Java")
//        list.add("Php")
//        list.add("Ios")
//        list.add("Android")
//        list.add("Java")
//        list.add("Php")
//        list.add("Ios")
//        list.add("Android")
//        list.add("Java")
//        list.add("Php")
//        list.add("Ios")
//        list.add("Android")
//        list.add("Java")
//        list.add("Php")
//        list.add("Ios")
//        list.add("Android")
//        list.add("Java")
//        list.add("Php")
//        list.add("Ios")
//        list.add("Android")
//        list.add("Java")
//        list.add("Php")
//        list.add("Ios")
//        list.add("Android")
//        list.add("Java")
//        list.add("Php")
//        list.add("Ios")
//        list.add("Android")
//        list.add("Java")
//        list.add("Php")
//        list.add("Ios")
//        list.add("Android")
//        list.add("Java")
//        list.add("Php")
//        list.add("Ios")
//        list.add("Android")
//        list.add("Java")
//        list.add("Php")
//        list.add("Ios")
//        list.add("Android")
//        list.add("Java")
//        list.add("Php")
//        list.add("Ios")
//        list.add("Ios")


        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        listview.adapter=adapter




    }
}