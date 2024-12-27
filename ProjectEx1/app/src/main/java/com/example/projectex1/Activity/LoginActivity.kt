package com.example.projectex1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projectex1.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textView3.setOnClickListener {

            startActivity(Intent(applicationContext,RegisterActivity::class.java))

        }

    }
}