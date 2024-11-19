package com.example.jsonparseex11

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
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException

class LoginActivity : AppCompatActivity()
{

    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edt1 = findViewById(R.id.eemail)
        edt2 = findViewById(R.id.epass)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            var stringrequest: StringRequest = object :StringRequest(
                Request.Method.POST,"https://prakrutitech.buzz/CRUD/login.php",{
                    response->

                try
                {
                    if(response.trim().equals("0"))
                    {
                        Toast.makeText(applicationContext,"Login Fail",Toast.LENGTH_LONG).show()
                    }
                    else
                    {
                        Toast.makeText(applicationContext,"Login Success",Toast.LENGTH_LONG).show()
                    }
                }
                catch (e: JSONException)
                {
                    print(e)
                }


            },
                {
                    Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
                })


            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map = HashMap<String,String>()
                    map["e1"]=edt1.text.toString()
                    map["p1"]=edt2.text.toString()
                    return map


                }
            }


            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringrequest)



        }

    }
}