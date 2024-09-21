package com.example.customdialogex

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{

    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            var alert = AlertDialog.Builder(this)
            var layout = LayoutInflater.from(applicationContext)
            var view = layout.inflate(R.layout.design,null)

            var edt1:EditText = view.findViewById(R.id.edt1)
            var btn1:Button = view.findViewById(R.id.btn1)

            btn1.setOnClickListener {

                var data = edt1.text.toString()

                Toast.makeText(applicationContext, ""+data, Toast.LENGTH_SHORT).show()
            }

            alert.setView(view)

            alert.show()

        }

    }

}