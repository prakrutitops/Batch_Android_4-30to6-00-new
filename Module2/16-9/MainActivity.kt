package com.example.viewbindingex

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.viewbindingex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{

    lateinit var binding:ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        Toast.makeText(applicationContext, "Created", Toast.LENGTH_SHORT).show()

        binding.txt1.setOnClickListener {

            Toast.makeText(applicationContext, "Msg 1", Toast.LENGTH_SHORT).show()
        }
        binding.txt2.setOnClickListener {

            Toast.makeText(applicationContext, "Msg 2", Toast.LENGTH_SHORT).show()
        }

    }


    override fun onStart()
    {
        Toast.makeText(applicationContext, "Started", Toast.LENGTH_SHORT).show()
        super.onStart()
    }


    override fun onPause() {
        Toast.makeText(applicationContext, "Pause", Toast.LENGTH_SHORT).show()
        super.onPause()
    }


    override fun onResume() {
        Toast.makeText(applicationContext, "Resumed", Toast.LENGTH_SHORT).show()
        super.onResume()
    }


    override fun onRestart() {
        Toast.makeText(applicationContext, "Restarted", Toast.LENGTH_SHORT).show()
        super.onRestart()
    }


    override fun onDestroy() {
        Toast.makeText(applicationContext, "Destroyed", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }


    override fun onStop() {
        Toast.makeText(applicationContext, "Stopped", Toast.LENGTH_SHORT).show()
        super.onStop()
    }
}