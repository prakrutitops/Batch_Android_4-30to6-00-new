package com.example.sqlitedbex

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{

    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var edt3:EditText
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edt1 = findViewById(R.id.edtname)
        edt2 = findViewById(R.id.edtnum)
        edt3 = findViewById(R.id.edtpass)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        dbHelper = DbHelper(applicationContext)

        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var num = edt2.text.toString()
            var pass = edt3.text.toString()

            //model set
            var m = Model()
            m.name=name
            m.num=num
            m.pass=pass

           var id = dbHelper.insertdata(m)
           Toast.makeText(applicationContext, "Record Inserted "+id, Toast.LENGTH_SHORT).show()
        }

    }
}