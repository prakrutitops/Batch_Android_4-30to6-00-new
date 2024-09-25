package com.example.menuex

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity(), PopupMenu.OnMenuItemClickListener {
    lateinit var btn1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn1 = findViewById(R.id.btn2)

        btn1.setOnClickListener {

            var popupmenu = PopupMenu(applicationContext,btn1)
            popupmenu.menuInflater.inflate(R.menu.popup_menu,popupmenu.menu)
            popupmenu.setOnMenuItemClickListener(this)
            popupmenu.show()

        }
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean
    {
        when(item!!.itemId)
        {
            R.id.i3->
            {
                Toast.makeText(applicationContext, "a", Toast.LENGTH_SHORT).show()
            }
        }


    return true
    }
}