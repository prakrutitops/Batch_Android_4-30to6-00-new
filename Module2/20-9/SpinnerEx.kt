package com.example.customlistex

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SpinnerEx : AppCompatActivity(), AdapterView.OnItemSelectedListener,
  RadioGroup.OnCheckedChangeListener {

    lateinit var spinner:Spinner
    lateinit var rg:RadioGroup
    lateinit var rb1:RadioButton
    lateinit var rb2:RadioButton
    var city = arrayOf("Rajkot","Baroda","Surat")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_spinner_ex)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spinner = findViewById(R.id.spin)
        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)
        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,city)
        spinner.adapter=adapter
        rg = findViewById(R.id.rg)
       spinner.setOnItemSelectedListener(this)

//       rb1.setOnCheckedChangeListener { buttonView, isChecked ->
//
//           Toast.makeText(applicationContext, "Male", Toast.LENGTH_SHORT).show()
//       }
//       rb2.setOnCheckedChangeListener { buttonView, isChecked ->
//
//           Toast.makeText(applicationContext, "Female", Toast.LENGTH_SHORT).show()
//       }
        rg.setOnCheckedChangeListener(this)

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {


        Toast.makeText(applicationContext, ""+city[position], Toast.LENGTH_SHORT).show()

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }




    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        if(rb1.isChecked==true)
        {
            Toast.makeText(applicationContext, "Male", Toast.LENGTH_SHORT).show()

        }
        else if(rb2.isChecked==true)
        {
            Toast.makeText(applicationContext, "Female", Toast.LENGTH_SHORT).show()

        }
    }
}