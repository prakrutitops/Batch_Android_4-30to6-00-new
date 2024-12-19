package com.example.gmailotp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity()
{
    lateinit var edt1: EditText
    lateinit var edt2: EditText
    lateinit var btn1: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            var n = edt1.text.toString()
            var e = edt2.text.toString()



            var stringrequest = object: StringRequest(Request.Method.POST,"https://prakrutitech.buzz/email.php",
                Response.Listener
                {
                    Toast.makeText(applicationContext,"Inserted",Toast.LENGTH_LONG).show()
                   // startActivity(Intent(applicationContext,MainActivity::class.java))
                },
                Response.ErrorListener
                {
                    Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
                })
            {
                override fun getParams(): MutableMap<String, String>?
                {

                    var map = HashMap<String,String>()
                    map["first_name"] = n
                    map["email"] = e


                    return map
                }
            }


            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringrequest)


        }
    }

}