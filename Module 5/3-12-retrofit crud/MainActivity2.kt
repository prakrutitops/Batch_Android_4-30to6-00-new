package com.example.retrofitcrudex1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitex.ApiClient
import com.example.retrofitex.Apiinterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity2 : AppCompatActivity()
{

    lateinit var recyclerview: RecyclerView
    lateinit var list:MutableList<Model>
    lateinit var apiinterface: Apiinterface


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerview = findViewById(R.id.recycle)
        list = ArrayList()

        var manager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager=manager

        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)

        var call: Call<List<Model>> = apiinterface.getdata()

        call.enqueue(object: Callback<List<Model>> {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>)
            {
                list = response.body() as MutableList<Model>

                var myAdapter = MyAdapter(applicationContext,list)
                recyclerview.adapter=myAdapter

            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                Toast.makeText(applicationContext,"No Internet", Toast.LENGTH_LONG).show()
            }
        })
    }
}