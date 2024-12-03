package com.example.retrofitcrudex1

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
import com.example.retrofitex.ApiClient
import com.example.retrofitex.Apiinterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var edt3:EditText
    lateinit var edt4:EditText
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var apiinterface: Apiinterface

    @SuppressLint("MissingInflatedId")
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
        edt3 = findViewById(R.id.edt3)
        edt4 = findViewById(R.id.edt4)
        btn1 = findViewById(R.id.btninsert)
        btn2 = findViewById(R.id.btnview)
        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var surname = edt2.text.toString()
            var email = edt3.text.toString()
            var pass = edt4.text.toString()

           var call: Call<Void> = apiinterface.insertdata(name,surname,email,pass)
            call.enqueue(object:Callback<Void>
            {
                override fun onResponse(call: Call<Void>, response: Response<Void>) {

                    Toast.makeText(applicationContext, "inserted", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext,MainActivity2::class.java))
                }

                override fun onFailure(call: Call<Void>, t: Throwable) {

                    Toast.makeText(applicationContext, "No Inernet", Toast.LENGTH_SHORT).show()

                }
            })

        }

        btn2.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity2::class.java))
        }


    }
}