package com.example.projectex1.Activity


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.classproject.clients.ApiClient
import com.example.classproject.interfaces.ApiInterface
import com.example.projectex1.LoginActivity
import com.example.projectex1.R
import com.example.projectex1.databinding.ActivityLoginBinding
import com.example.projectex1.databinding.ActivityWishlistAddBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartAddActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityWishlistAddBinding
    lateinit var apiInterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityWishlistAddBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var g_name = i.getStringExtra("gift_name")
        var g_desc = i.getStringExtra("gift_desc")
        var g_price = i.getStringExtra("gift_price")
        var g_image = i.getStringExtra("gift_image")
        var mob = i.getStringExtra("mobile")
       // Toast.makeText(applicationContext, ""+g_name, Toast.LENGTH_SHORT).show()

        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
//
       var call: Call<Void> = apiInterface.addDataToCart(g_name,g_desc,g_price,g_image,mob)
//
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {

                startActivity(Intent(applicationContext, CartAcivity::class.java))
            }

            override fun onFailure(call: Call<Void>, t: Throwable)
            {
                Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG)
                    .show()
            }
        })


    }
}