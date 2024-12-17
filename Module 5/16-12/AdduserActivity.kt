package com.example.firebasecrudex

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.FirebaseDatabase

class AdduserActivity : AppCompatActivity()
{

    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var edt3:EditText
    lateinit var btn1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adduser)


        edt1 = findViewById(R.id.edtname)
        edt2 = findViewById(R.id.edtnum)
        edt3 = findViewById(R.id.edtemail)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var num = edt2.text.toString()
            var email = edt3.text.toString()

            var map = HashMap<String,String>()
            map["name"]=name
            map["email"]=email
            map["num"]=num

            var db = FirebaseDatabase.getInstance()
                .getReference()
                .child("tops")
                .push()
                .setValue(map)
                .addOnSuccessListener {

                    Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext, MainActivity::class.java))

                }
                .addOnFailureListener {
                    Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show()
                }



        }


    }
}