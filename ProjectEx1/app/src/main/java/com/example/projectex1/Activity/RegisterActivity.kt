package com.example.projectex1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.classproject.clients.ApiClient
import com.example.classproject.interfaces.ApiInterface
import com.example.projectex1.R
import com.example.projectex1.databinding.ActivityLoginBinding
import com.example.projectex1.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    private lateinit var binding: ActivityRegisterBinding
    private var gender1 = ""
    lateinit var apiinterface: ApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.rbMale.setOnCheckedChangeListener(this)
        binding.rbFemale.setOnCheckedChangeListener(this)

        binding.btnsignup.setOnClickListener {

            val fname = binding.edtFirstName.text.toString()
            val lname = binding.edtLastName.text.toString()
            val email = binding.edtEmail.text.toString()
            val phone = binding.edtPhone.text.toString()
            val pass = binding.edtPassword.text.toString()
            val gender = gender1

            if (pass.isEmpty()) {
                Toast.makeText(
                    applicationContext,
                    "Please Enter Proper Password",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                if (fname.isEmpty()) {
                    binding.edtFirstName.error = "Please Enter Proper FirstName"
                } else if (lname.isEmpty()) {
                    binding.edtLastName.error = "Please Enter Proper LastName"
                } else if (email.isEmpty()) {
                    binding.edtEmail.error = "Please Enter Proper Email"
                } else if (phone.length != 10) {
                    binding.edtPhone.error = "Please Enter Proper Phone Number"
                } else {
                    apiinterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

                    val registercall: Call<Void> =
                        apiinterface.registerdetail(fname, lname, gender, email, phone, pass)
                    registercall.enqueue(object : Callback<Void> {
                        override fun onResponse(call: Call<Void>, response: Response<Void>) {

                            startActivity(Intent(applicationContext, LoginActivity::class.java))
                        }

                        override fun onFailure(call: Call<Void>, t: Throwable) {
                            Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG)
                                .show()
                        }
                    })
                }


            }



            binding.textView3.setOnClickListener {

                startActivity(Intent(applicationContext, RegisterActivity::class.java))

            }
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        if (binding.rbMale.isChecked) {
            gender1 = "Male"
        }
        if (binding.rbFemale.isChecked) {
            gender1 = "Female"
        }
    }
}

