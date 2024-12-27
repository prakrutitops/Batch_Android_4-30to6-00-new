package com.example.projectex1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projectex1.R
import com.example.projectex1.databinding.ActivityLoginBinding
import com.example.projectex1.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textView3.setOnClickListener {

            startActivity(Intent(applicationContext,RegisterActivity::class.java))

        }
    }
}