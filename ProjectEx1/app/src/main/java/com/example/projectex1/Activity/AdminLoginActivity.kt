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
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        binding = ActivityAdminLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        apiInterface= ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        binding.btnlogin.setOnClickListener {

            var uname = binding.edtunameadmin.text.toString()
            var pass = binding.edtpassadmin.text.toString()

            val call: Call<RegisterModel> = apiInterface.adminlogin(uname,pass)
            call.enqueue(object: Callback<RegisterModel> {
                override fun onResponse(
                    call: Call<RegisterModel>,
                    response: Response<RegisterModel>, )
                    {


                    Toast.makeText(applicationContext,"Success", Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext, AddCategoryActivity::class.java))

                }

                override fun onFailure(call: Call<RegisterModel>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"Fail", Toast.LENGTH_LONG).show()

                }
            })

        }


    }
}