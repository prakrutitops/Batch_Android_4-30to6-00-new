package com.example.test45

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class UpdateActivity : AppCompatActivity()
{
    lateinit var edt1: EditText
    lateinit var edt2: EditText

    lateinit var btn1: Button
    lateinit var dbHelper: DbHelper

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_update)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        edt1 = findViewById(R.id.edtname)
        edt2 = findViewById(R.id.edtnum)

        btn1 = findViewById(R.id.btn1)
        dbHelper = DbHelper(applicationContext)

        var i = intent
        var id = i.getIntExtra("id",0)

        i.getStringExtra("num")
        i.getStringExtra("pass")
        edt1.setText(i.getStringExtra("name"))
        edt2.setText(i.getStringExtra("num"))


    btn1.setOnClickListener {

        var name = edt1.text.toString()
        var num = edt2.text.toString()


        //model set
        var m = Model()
        m.id=id
        m.name=name
        m.num=num

         dbHelper.updatedata(m)
        startActivity(Intent(applicationContext,ViewActivity::class.java))
    }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }




}