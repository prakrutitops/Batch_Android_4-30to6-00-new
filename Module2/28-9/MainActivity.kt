package com.example.permissionex

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.CALL_PHONE
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity()
{
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn1 = findViewById(R.id.btn1)

        checkpermission()
        if(checkpermission())
        {
            Toast.makeText(applicationContext, "permission granted", Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(applicationContext, "please allow the permission", Toast.LENGTH_SHORT).show()
            requestpermission()

        }



        btn1.setOnClickListener {

            var num="9988998899"
            var i = Intent(Intent.ACTION_CALL)
            i.setData(Uri.parse("tel:"+num))
            startActivity(i)
        }
    }

    private fun requestpermission()
    {
        ActivityCompat.requestPermissions(this@MainActivity, arrayOf(CALL_PHONE), 200)

    }

    private fun checkpermission() : Boolean
    {
        val a = ContextCompat.checkSelfPermission(this@MainActivity, ACCESS_FINE_LOCATION)

        val b = ContextCompat.checkSelfPermission(this@MainActivity, CALL_PHONE)

        return a==PackageManager.PERMISSION_GRANTED && b== PackageManager.PERMISSION_GRANTED
    }
}