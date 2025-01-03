package com.example.projectex1.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classproject.clients.ApiClient
import com.example.classproject.interfaces.ApiInterface
import com.example.projectex1.DashboardAdapter
import com.example.projectex1.LoginActivity
import com.example.projectex1.Model.DashboardModel
import com.example.projectex1.R
import com.example.projectex1.WishlistAdapter
import com.example.projectex1.WishlistModel
import com.example.projectex1.databinding.ActivityDashboardBinding
import com.example.projectex1.databinding.ActivityWishlistBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WishlistActivity : AppCompatActivity()
{
    lateinit var sharedPreferences: SharedPreferences
    lateinit var toolbar:Toolbar
    private lateinit var binding: ActivityWishlistBinding
    lateinit var apiInterface: ApiInterface
    lateinit var list:MutableList<WishlistModel>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityWishlistBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

//        if (Build.VERSION.SDK_INT >= 21)
//        {
//            val window = this.window
//            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
//            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            window.statusBarColor = this.resources.getColor(R.color.bluegrey)
//        }

        toolbar = findViewById(R.id.tool)
        setSupportActionBar(toolbar)

        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)
        Toast.makeText(applicationContext,"Welcome "+sharedPreferences.getString("mob",""), Toast.LENGTH_LONG).show()
        var mob = sharedPreferences.getString("mob","");

        var layoutmanager :RecyclerView.LayoutManager = GridLayoutManager(applicationContext,2)
        binding.recyclerView.layoutManager=layoutmanager

        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
        list = ArrayList()

        var call: Call<List<WishlistModel>> = apiInterface.wishlistViewData(mob!!)

        call.enqueue(object: Callback<List<WishlistModel>>
        {
            override fun onResponse(call: Call<List<WishlistModel>>, response: Response<List<WishlistModel>>)
            {
                list = response.body() as MutableList<WishlistModel>

                var adapter = WishlistAdapter(applicationContext,list)
                binding.recyclerView.adapter=adapter

            }

            override fun onFailure(call: Call<List<WishlistModel>>, t: Throwable)
            {
                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
            }
        })





    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.logout->
            {
                sharedPreferences.edit().clear().commit()
                startActivity(Intent(applicationContext, LoginActivity::class.java))
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}