package com.example.edittextwithvalidation

import android.content.Intent
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


    override fun onCreate(savedInstanceState: Bundle?) {
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

        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var pass = edt2.text.toString()

            //validation

            if(name.length==0 && pass.length==0)
            {
                edt1.setError("Please Enter Your Name")
                edt2.setError("Please Enter Your Password")
            }
            else if(name.length==0)
            {
                edt1.setError("Please Enter Your Name")

            }
            else if(pass.length==0)
            {
                edt2.setError("Please Enter Your Password")

            }
            else
            {
                if(name.equals("admin@gmail.com")&& pass.equals("1234"))
                {
                    Toast.makeText(applicationContext, "Login Done", Toast.LENGTH_SHORT).show()

                        var i = Intent(applicationContext,MainActivity2::class.java)
                        startActivity(i)
                }
                else
                {
                    Toast.makeText(applicationContext, "Login Fail", Toast.LENGTH_SHORT).show()
                }

            }









        }

    }


}