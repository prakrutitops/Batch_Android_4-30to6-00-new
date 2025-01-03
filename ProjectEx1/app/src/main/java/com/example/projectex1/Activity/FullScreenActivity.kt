package com.example.projectex1.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projectex1.R
import com.example.projectex1.databinding.ActivityFullScreenBinding
import com.squareup.picasso.Picasso

class FullScreenActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityFullScreenBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)
        var data = sharedPreferences.getString("mob", "")
        val intent = intent
        val image = intent.getStringExtra("image")
        val giftName = intent.getStringExtra("name")
        val giftDesc = intent.getStringExtra("desc")
        val giftPrice = intent.getStringExtra("price")

        Picasso.get().load(image).into(binding.imageView)
        binding.giftName.text = giftName
        binding.giftDesc.text = giftDesc
        binding.giftPrice.text = giftPrice

        binding.wishListButton.setOnClickListener {

            var i = Intent(applicationContext,WishlistAddActivity::class.java)
            i.putExtra("gift_name",giftName)
            i.putExtra("gift_desc",giftDesc)
            i.putExtra("gift_price",giftPrice)
            i.putExtra("gift_image",image)
            i.putExtra("mobile",data)
            startActivity(i)




        }
        binding.cartButton.setOnClickListener {


        }

    }
}