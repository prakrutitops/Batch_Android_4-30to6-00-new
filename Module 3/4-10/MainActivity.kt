package com.example.recycleviewex

import android.annotation.SuppressLint
import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity()
{
    lateinit var recyclerview:RecyclerView
    lateinit var list:MutableList<Model>

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

        recyclerview = findViewById(R.id.recycler)
        list = ArrayList()

        var manager:RecyclerView.LayoutManager = GridLayoutManager(this,2)
        recyclerview.layoutManager=manager


        list.add(Model(R.drawable.a,"one"))
        list.add(Model(R.drawable.abc,"two"))
        list.add(Model(R.drawable.photo,"three"))

        var adapter = MyAdapter(applicationContext,list)
        recyclerview.adapter=adapter

    }
}