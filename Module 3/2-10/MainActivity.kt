package com.example.sharedprefrenceex1

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
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
    lateinit var btn1:Button
    lateinit var sharedPreferences: SharedPreferences

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

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        sharedPreferences = getSharedPreferences("tops", MODE_PRIVATE)

        if(sharedPreferences.getBoolean("tops",false) && !sharedPreferences.getString("e1","")!!.isEmpty())
        {
                var i = Intent(applicationContext,MainActivity2::class.java)
                startActivity(i)
                finish()
        }



        btn1.setOnClickListener {

            var email = edt1.text.toString()
            var pass = edt2.text.toString()


            if(email.equals("a@gmail.com") && pass.equals("1234"))
            {
                var s1 :SharedPreferences.Editor = sharedPreferences.edit()
                s1.putBoolean("tops",true)
                s1.putString("e1",email)
                s1.putString("p1",pass)
                s1.commit()

                var i = Intent(applicationContext,MainActivity2::class.java)
                startActivity(i)

            }
            else
            {
                Toast.makeText(applicationContext, "incorrect credentials", Toast.LENGTH_SHORT).show()
            }


        }

    }
}