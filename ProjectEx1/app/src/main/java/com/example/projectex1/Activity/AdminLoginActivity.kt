package com.example.projectex1.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.classproject.clients.ApiClient
import com.example.classproject.interfaces.ApiInterface
import com.example.projectex1.R
import com.example.projectex1.databinding.ActivityAdminLoginBinding
import com.example.projectex1.databinding.ActivityWishlistAddBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tops.tech.batchproject_morning.RegisterModel

class AdminLoginActivity : AppCompatActivity()
{
    lateinit var binding:ActivityAdminLoginBinding
    lateinit var apiInterface: ApiInterface
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        binding = ActivityAdminLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        apiInterface= ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        sharedPreferences = getSharedPreferences("admin_session", Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("admin_session", false) &&
            sharedPreferences.getString("mob", "")!!.isNotEmpty()) {
            startActivity(Intent(this, AdminDashboardActivity::class.java))
            finish()
        }

        binding.btnlogin.setOnClickListener {

            var uname = binding.edtunameadmin.text.toString()
            var pass = binding.edtpassadmin.text.toString()

            val call: Call<RegisterModel> = apiInterface.adminlogin(uname,pass)
            call.enqueue(object: Callback<RegisterModel> {
                override fun onResponse(
                    call: Call<RegisterModel>,
                    response: Response<RegisterModel>, )
                    {
                        sharedPreferences.edit().putString("mob",uname).commit()
                        sharedPreferences.edit().putBoolean("admin_session",true).commit()

                    Toast.makeText(applicationContext,"Success", Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext, AdminDashboardActivity::class.java))

                }

                override fun onFailure(call: Call<RegisterModel>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"Fail", Toast.LENGTH_LONG).show()

                }
            })

        }


    }
}