package com.example.projectex1.Activity

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.classproject.clients.ApiClient
import com.example.classproject.interfaces.ApiInterface
import com.example.projectex1.WishlistAdapter
import com.example.projectex1.WishlistModel
import com.example.projectex1.databinding.ActivityWishlistBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WishlistActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityWishlistBinding
    private lateinit var mutableList: MutableList<WishlistModel>
    lateinit var apiInterface: ApiInterface
    lateinit var sharedPreferences: SharedPreferences
    lateinit var mAdapter: WishlistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWishlistBinding.inflate(layoutInflater)
        val view = binding.root
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Setting up ActionBar
        binding.tool.title = "My Wishlist"
        setSupportActionBar(binding.tool)
        binding.tool.setNavigationOnClickListener {
            super.finish()


        }
        setContentView(view)
        // Setting up activity window


        mutableList = ArrayList()
        mAdapter = WishlistAdapter(applicationContext, mutableList)
        binding.recycler.layoutManager = LinearLayoutManager(this)

       //sharedprefrence
        sharedPreferences = getSharedPreferences("user_session", MODE_PRIVATE)
        val mob = sharedPreferences.getString("mob", "")


        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
        val call = apiInterface.wishlistViewData(mob)
        call.enqueue(object : Callback<List<WishlistModel>> {
            override fun onResponse(
                call: Call<List<WishlistModel>>,
                response: Response<List<WishlistModel>>
            ) {

                //Log.d("Mydata123",response.body().toString())


                mutableList = response.body() as MutableList<WishlistModel>
                Toast.makeText(applicationContext, ""+mutableList.size, Toast.LENGTH_SHORT).show()
                mAdapter = WishlistAdapter(applicationContext, mutableList)
                //binding.progressIndicator.visibility = View.GONE
               binding.recycler.adapter = mAdapter
            }

            override fun onFailure(call: Call<List<WishlistModel>>, t: Throwable) {
                Toast.makeText(this@WishlistActivity, "Failed", Toast.LENGTH_SHORT).show()
            }
        })

    }


}
