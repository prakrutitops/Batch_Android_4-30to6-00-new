package com.example.jsonex2

import android.os.Bundle
import android.view.Display.Mode
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


        var stringRequest = StringRequest(Request.Method.GET,"https://jsonplaceholder.org/posts",
            object: Response.Listener<String>
            {
                override fun onResponse(response: String?) {
                    var jsonarray = JSONArray(response)
                    for (i in 0 until jsonarray.length())
                    {
                        var jsonObject = jsonarray.getJSONObject(i)

                        var title = jsonObject.getString("title")
                        var status = jsonObject.getString("status")
                        var image = jsonObject.getString("image")

                        var m = Model()
                        m.title=title
                        m.status=status
                        m.image=image

                        list.add(m)


                    }

                    var myadapter = MyAdapter(applicationContext,list)
                    listView.adapter=myadapter


                }
            },

            object :Response.ErrorListener
            {
                override fun onErrorResponse(error: VolleyError?)
                {
                    Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_SHORT).show()
                }

            })

            var queue:RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringRequest)


    }
}