package com.example.retrofitregisterloginex

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

class SignupActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var edt3:EditText
    lateinit var edt4:EditText
    lateinit var btn2:Button
    lateinit var apiinterface: Apiinterface
    lateinit var btn1:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edt1 = findViewById(R.id.edtname)
        edt2 = findViewById(R.id.edtsurname)
        edt3 = findViewById(R.id.edtemail)
        edt4 = findViewById(R.id.edtpass)

        btn2 = findViewById(R.id.btnsignup)

        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)
        btn1 = findViewById(R.id.btn1)
        btn2.setOnClickListener {

            var n = edt1.text.toString()
            var s = edt2.text.toString()
            var e = edt3.text.toString()
            var p = edt4.text.toString()

            var call: Call<Void> = apiinterface.registerdata(n,s,e,p)
            call.enqueue(object :Callback<Void>{
                override fun onResponse(call: Call<Void>, response: Response<Void>)
                {
                    Toast.makeText(applicationContext,"Signup Success", Toast.LENGTH_LONG).show()

                }

                override fun onFailure(call: Call<Void>, t: Throwable) {
                    Toast.makeText(applicationContext,"Signup Fail",Toast.LENGTH_LONG).show()

                }
            })

        }
        btn1.setOnClickListener {


            startActivity(Intent(applicationContext,MainActivity::class.java))

        }
    }
}