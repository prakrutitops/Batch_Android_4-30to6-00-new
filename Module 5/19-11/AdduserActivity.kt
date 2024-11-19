package com.example.jsonparseex11

import android.content.Intent
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
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class AdduserActivity : AppCompatActivity() {

    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var edt3:EditText
    lateinit var edt4:EditText
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_adduser)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        edt1 = findViewById(R.id.ename)
        edt2 = findViewById(R.id.esurname)
        edt3 = findViewById(R.id.eemail)
        edt4 = findViewById(R.id.epass)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            var n = edt1.text.toString()
            var s = edt2.text.toString()
            var e = edt3.text.toString()
            var p = edt4.text.toString()


         var stringrequest = object:StringRequest(Request.Method.POST,"https://prakrutitech.buzz/CRUD/insert.php",
             Response.Listener
             {
                 Toast.makeText(applicationContext,"Inserted",Toast.LENGTH_LONG).show()
                 startActivity(Intent(applicationContext,MainActivity::class.java))
             },
             Response.ErrorListener
             {
                 Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
             })
            {
                override fun getParams(): MutableMap<String, String>?
                {

                    var map = HashMap<String,String>()
                    map["name"] = n
                    map["surname"] = s
                    map["email"] = e
                    map["password"] = p

                    return map
                }
            }


            var queue:RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringrequest)
        }

    }
}