package com.example.projectex1.Activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classproject.clients.ApiClient
import com.example.classproject.interfaces.ApiInterface
import com.example.projectex1.Adapter.AdminDashboardAdapter
import com.example.projectex1.DashboardAdapter
import com.example.projectex1.LoginActivity
import com.example.projectex1.Model.AdminDashboardModel
import com.example.projectex1.Model.DashboardModel
import com.example.projectex1.Model.Payment
import com.example.projectex1.PaymentViewAdapter
import com.example.projectex1.R
import com.example.projectex1.databinding.ActivityAddCategoryBinding
import com.example.projectex1.databinding.ActivityAdminDashboardBinding
import com.example.projectex1.databinding.ActivityPaymentBinding
import com.example.projectex1.databinding.ActivityPaymentViewBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaymentViewActivity : AppCompatActivity()
{
    lateinit var list:MutableList<Payment>
    lateinit var sharedPreferences: SharedPreferences
    lateinit var binding:ActivityPaymentViewBinding
    lateinit var apiInterface: ApiInterface

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (Build.VERSION.SDK_INT >= 21)
        {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.black)
        }

        sharedPreferences = getSharedPreferences("admin_session", Context.MODE_PRIVATE)
        Toast.makeText(applicationContext,"Welcome "+sharedPreferences.getString("mob",""), Toast.LENGTH_LONG).show()
        list = ArrayList()


        setSupportActionBar(binding.tool)
        var layoutmanager : RecyclerView.LayoutManager = GridLayoutManager(applicationContext,2)
        binding.recycler.layoutManager=layoutmanager

        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        var call: Call<List<Payment>> = apiInterface.paymentview()

        call.enqueue(object: Callback<List<Payment>>
        {
            override fun onResponse(call: Call<List<Payment>>, response: Response<List<Payment>>)
            {
                list = response.body() as MutableList<Payment>

                var adapter = PaymentViewAdapter(applicationContext,list)
                binding.recycler.adapter=adapter

            }

            override fun onFailure(call: Call<List<Payment>>, t: Throwable)
            {
                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
            }
        })




    }


}