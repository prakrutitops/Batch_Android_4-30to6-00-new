package com.example.firebasecrudex

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.FirebaseDatabase
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

class MainActivity : AppCompatActivity()
{
    lateinit var f1:FloatingActionButton
    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter : MyAdapter

    @SuppressLint("MissingInflatedId")
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

        f1 = findViewById(R.id.f1)
        recyclerView = findViewById(R.id.recycler)

        var layoutmanager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager=layoutmanager

        var options = FirebaseRecyclerOptions.Builder<Model>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("tops"), Model::class.java)
            .build()

         myAdapter = MyAdapter(options)
        recyclerView.adapter=myAdapter



        f1.setOnClickListener {

            startActivity(Intent(applicationContext,AdduserActivity::class.java))
        }
    }
    override fun onStart()
    {
        super.onStart()
        myAdapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        myAdapter.stopListening()
    }

    override fun onRestart() {
        super.onRestart()
        myAdapter.startListening()
    }

    override fun onResume() {
        super.onResume()
        myAdapter.startListening()
    }

    override fun onPause() {
        super.onPause()
        myAdapter.stopListening()
    }
}