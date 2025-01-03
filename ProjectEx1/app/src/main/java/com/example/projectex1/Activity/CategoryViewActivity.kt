package com.example.projectex1.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.classproject.clients.ApiClient
import com.example.classproject.interfaces.ApiInterface
import com.example.projectex1.CategoryAdapter
import com.example.projectex1.DashboardAdapter
import com.example.projectex1.Model.CategoryModel
import com.example.projectex1.Model.DashboardModel
import com.example.projectex1.R
import com.example.projectex1.databinding.ActivityCategoryViewBinding
import com.example.projectex1.databinding.ActivityDashboardBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tops.tech.batchproject_morning.RegisterModel

class CategoryViewActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityCategoryViewBinding
    lateinit var apiInterface: ApiInterface
    lateinit var list:MutableList<CategoryModel>
    lateinit var call: Call<List<CategoryModel>>
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityCategoryViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var pos = i.getIntExtra("pos",404)
        var pos2 = pos+1
        Toast.makeText(applicationContext, ""+pos2.toInt(), Toast.LENGTH_SHORT).show()

        var layoutManager: RecyclerView.LayoutManager = GridLayoutManager(applicationContext,2)
        binding.recycler.layoutManager=layoutManager


        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        call = apiInterface.categoryviewdata(pos2)

        call.enqueue(object: Callback<List<CategoryModel>>
        {
            override fun onResponse(call: Call<List<CategoryModel>>, response: Response<List<CategoryModel>>)
            {
                list = response.body() as MutableList<CategoryModel>
                Toast.makeText(applicationContext, ""+list.size, Toast.LENGTH_SHORT).show()
                //Toast.makeText(applicationContext, ""+list.get(1), Toast.LENGTH_SHORT).show()

                var adapter = CategoryAdapter(applicationContext,list)
                binding.recycler.adapter=adapter

            }

            override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable)
            {
                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
            }
        })




    //
//        var layoutManager: RecyclerView.LayoutManager = GridLayoutManager(applicationContext,2)
//        binding.recycler.layoutManager=layoutManager
//
//        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
//        list = ArrayList()

//        if(pos==0)
//        {
//            call = apiInterface.books_viewdata()
//        }
//        if(pos==1)
//        {
//            call = apiInterface.clothescategory_viewdata()
//        }
//        if(pos==2)
//        {
//            call = apiInterface.elec_viewdata()
//        }
//        if(pos==3)
//        {
//            call = apiInterface.flower_viewdata()
//        }

//        call.enqueue(object: Callback<List<CategoryModel>>
//        {
//            override fun onResponse(call: Call<List<CategoryModel>>, response: Response<List<CategoryModel>>)
//            {
//                list = response.body() as MutableList<CategoryModel>
//
//                var adapter = CategoryAdapter(applicationContext,list)
//                binding.recycler.adapter=adapter
//
//            }
//
//            override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable)
//            {
//                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
//            }
//        })



    }
}