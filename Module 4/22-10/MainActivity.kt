package com.example.roomdbex

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.roomdbex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var db: DatabaseClass
    lateinit var list: MutableList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        db = Room.databaseBuilder(applicationContext, DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()
        list = ArrayList()

        var rm:RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager=rm

        list = db.daoClass().viewdata()

        var adapter = MyAdapter(applicationContext,list)
        binding.recycler.adapter=adapter

        binding.f1.setOnClickListener {

            startActivity(Intent(applicationContext,AdduserActivity::class.java))
        }


    }
}