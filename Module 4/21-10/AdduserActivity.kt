package com.example.roomdbex

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.Room
import com.example.roomdbex.databinding.ActivityAdduserBinding

class AdduserActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityAdduserBinding

    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var db:DatabaseClass

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityAdduserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        db = Room.databaseBuilder(applicationContext, DatabaseClass::class.java, "myDatabase")
            .allowMainThreadQueries()
            .build()

        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var email = edt2.text.toString()

            var u = User()
            u.name=name
            u.email=email

            db.daoClass().insertdata(u)
            Toast.makeText(applicationContext,"Inserted", Toast.LENGTH_LONG).show()

        }


    }
}