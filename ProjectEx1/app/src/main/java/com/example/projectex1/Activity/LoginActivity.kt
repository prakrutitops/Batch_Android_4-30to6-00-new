package com.example.projectex1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
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
    var mobilePattern = "[0-9]"

    var passpattern: String = ("^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (Build.VERSION.SDK_INT >= 21)
        {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.black)
        }

        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("user_session", false) &&
            sharedPreferences.getString("mob", "")!!.isNotEmpty()) {
            startActivity(Intent(this, DashboardActivity::class.java))
            finish()
        }

        apiInterface= ApiClient.getapiclient()!!.create(ApiInterface::class.java)


        binding.btnLogIn.setOnClickListener {

            val phone = binding.edtPhone.text.toString()
            val pass = binding.edtPassword.text.toString()

            if (phone.length != 10)
            {
             binding.edtPhone.error = "Please Enter Proper Phone Number"
            }
            else if (isnum(phone))
            {
                binding.edtPhone.error = "Please Enter Proper Phone Number"
            }
            else if (pass.isEmpty())
            {
                binding.edtPassword.error = "Please Enter Password"
            }
            else if(!ispass(pass))
            {
                binding.edtPassword.error = "Please Enter Proper Password"
            }
            else
            {
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

        }



        binding.textView3.setOnClickListener {

            startActivity(Intent(applicationContext,RegisterActivity::class.java))

        }

    }
    fun isnum(num: String): Boolean
    {
        return num.matches(mobilePattern.toRegex())
    }
    fun ispass(pass: String): Boolean
    {
        return pass.matches(passpattern.toRegex())
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}