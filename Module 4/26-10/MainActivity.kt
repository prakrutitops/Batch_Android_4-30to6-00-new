package com.example.realmex1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.realm.Realm

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        edt1 = findViewById(R.id.edtname)
        edt2 = findViewById(R.id.edtnum)
        btn1 = findViewById(R.id.btninsert)
        btn2 = findViewById(R.id.btnview)

        realm = Realm.getInstance(Realm.getDefaultConfiguration())

        btn1.setOnClickListener {

            var name = edt1.text.toString()
            var num = edt2.text.toString()

            realm.beginTransaction()

            var m = realm.createObject(Model::class.java)
            m.name = name
            m.num=num

            realm.commitTransaction()

            Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_SHORT).show()

        }

        btn2.setOnClickListener {

        }



    }
}