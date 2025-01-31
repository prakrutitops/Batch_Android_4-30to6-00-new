package com.example.projectex1.Activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
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
class CategoryViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCategoryViewBinding
    lateinit var apiInterface: ApiInterface
    lateinit var list: MutableList<CategoryModel>
    lateinit var call: Call<List<CategoryModel>>
    var pos2 = 0
    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCategoryViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.tool)

        var i = intent
        var pos = i.getIntExtra("pos", 404)
        pos2 = pos + 1
        Toast.makeText(applicationContext, "" + pos2.toInt(), Toast.LENGTH_SHORT).show()

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.white)
        }

        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(applicationContext, 2)
        binding.recycler.layoutManager = layoutManager

        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        call = apiInterface.categoryviewdata(pos2)
        call.enqueue(object : Callback<List<CategoryModel>> {
            override fun onResponse(call: Call<List<CategoryModel>>, response: Response<List<CategoryModel>>) {
                list = response.body() as MutableList<CategoryModel>
                Toast.makeText(applicationContext, "" + list.size, Toast.LENGTH_SHORT).show()

                adapter = CategoryAdapter(applicationContext, list)
                binding.recycler.adapter = adapter
            }

            override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()
            }
        })

        // Set up the SearchView to filter the RecyclerView items
        val searchView: SearchView = findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredList = list.filter {
                    it.name!!.contains(newText ?: "", ignoreCase = true) // filtering based on name
                }
                adapter.updateList(filteredList)
                return true
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.ordermenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.i1 -> {
                call = apiInterface.categorylowtohigh(pos2)
                call.enqueue(object : Callback<List<CategoryModel>> {
                    override fun onResponse(call: Call<List<CategoryModel>>, response: Response<List<CategoryModel>>) {
                        list = response.body() as MutableList<CategoryModel>
                        Toast.makeText(applicationContext, "" + list.size, Toast.LENGTH_SHORT).show()
                        adapter.updateList(list)
                    }

                    override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                        Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()
                    }
                })
            }
            R.id.i2 -> {
                call = apiInterface.categoryhightolow(pos2)
                call.enqueue(object : Callback<List<CategoryModel>> {
                    override fun onResponse(call: Call<List<CategoryModel>>, response: Response<List<CategoryModel>>) {
                        list = response.body() as MutableList<CategoryModel>
                        Toast.makeText(applicationContext, "" + list.size, Toast.LENGTH_SHORT).show()
                        adapter.updateList(list)
                    }

                    override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {
                        Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()
                    }
                })
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
