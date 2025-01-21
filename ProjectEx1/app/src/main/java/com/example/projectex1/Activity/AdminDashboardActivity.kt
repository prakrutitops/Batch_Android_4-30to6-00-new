package com.example.projectex1.Activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projectex1.Adapter.AdminDashboardAdapter
import com.example.projectex1.LoginActivity
import com.example.projectex1.Model.AdminDashboardModel
import com.example.projectex1.R

class AdminDashboardActivity : AppCompatActivity()
{
    lateinit var grid:GridView
    lateinit var list:MutableList<AdminDashboardModel>
    lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dashboard)

        sharedPreferences = getSharedPreferences("admin_session", Context.MODE_PRIVATE)
        Toast.makeText(applicationContext,"Welcome "+sharedPreferences.getString("mob",""), Toast.LENGTH_LONG).show()


        grid = findViewById(R.id.grid)
        list = ArrayList()

        list.add(AdminDashboardModel(R.drawable.baseline_add_box_24,"Add Product"))
        list.add(AdminDashboardModel(R.drawable.baseline_preview_24,"View Product"))
        list.add(AdminDashboardModel(R.drawable.baseline_logout_24,"Logout"))

        var adapter = AdminDashboardAdapter(applicationContext,list)
        grid.adapter=adapter

        grid.setOnItemClickListener { parent, view, position, id ->

            if(position==0)
            {
                startActivity(Intent(applicationContext,AddCategoryActivity::class.java))
            }
            if(position==1)
            {
                startActivity(Intent(applicationContext,AddProductActivity::class.java))
            }
            if(position==2)
            {
                sharedPreferences.edit().clear().commit()
                startActivity(Intent(applicationContext, LoginActivity::class.java))
                finish()
            }


        }


    }
}