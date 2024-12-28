package com.example.projectex1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.classproject.clients.ApiClient
import com.example.classproject.interfaces.ApiInterface
import com.example.projectex1.Activity.DashboardActivity
import com.example.projectex1.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tops.tech.batchproject_morning.RegisterModel

class LoginActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding
    lateinit var apiInterface: ApiInterface
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("user_session", false) &&
            sharedPreferences.getString("mob", "")!!.isNotEmpty()) {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }



        binding.btnLogIn.setOnClickListener {

            val phone = binding.edtPhone.text.toString()
            val pass = binding.edtPassword.text.toString()

            apiInterface= ApiClient.getapiclient()!!.create(ApiInterface::class.java)
            val call: Call<RegisterModel> = apiInterface.logindata(phone,pass)
            call.enqueue(object: Callback<RegisterModel> {
                override fun onResponse(
                    call: Call<RegisterModel>,
                    response: Response<RegisterModel>, )
                {
                    sharedPreferences.edit().putString("mob",phone).commit()
                    sharedPreferences.edit().putBoolean("user_session",true).commit()

                    Toast.makeText(applicationContext,"Success", Toast.LENGTH_LONG).show()
                    startActivity(Intent(applicationContext, DashboardActivity::class.java))

                }

                override fun onFailure(call: Call<RegisterModel>, t: Throwable)
                {
                    Toast.makeText(applicationContext,"Fail", Toast.LENGTH_LONG).show()

                }
            })
        }



        binding.textView3.setOnClickListener {

            startActivity(Intent(applicationContext,RegisterActivity::class.java))

        }

    }

    override fun onBackPressed() {
        finishAffinity()
    }
}