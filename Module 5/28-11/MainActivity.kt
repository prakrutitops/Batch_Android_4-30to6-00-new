package com.example.jsonex1

import android.os.Bundle
import android.util.Log
import android.widget.ListView
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
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listView = findViewById(R.id.list)
        list = ArrayList()

        var stringRequest = StringRequest(Request.Method.GET,"https://www.simplifiedcoding.net/demos/view-flipper/heroes.php",object:Response.Listener<String>{
            override fun onResponse(response: String?)
                {

                    Log.d("topsdata",response.toString())

                        var jsonObject = JSONObject(response)
                        var jsonarray = jsonObject.getJSONArray("heroes")
                        for(i in 0 until jsonarray.length())
                        {
                            var jsonObject2 = jsonarray.getJSONObject(i)

                            var name = jsonObject2.getString("name")
                            var image = jsonObject2.getString("imageurl")

                            var m = Model()
                            m.name=name
                            m.image=image
                            list.add(m)

                        }

                    var myadapter = MyAdapter(applicationContext,list)
                    listView.adapter=myadapter

                }



            },
            object:Response.ErrorListener
            {
                override fun onErrorResponse(error: VolleyError?)
                {
                    Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_SHORT).show()
                }
        })

        var queue:RequestQueue = Volley.newRequestQueue(    this)
        queue.add(stringRequest)

    }
}