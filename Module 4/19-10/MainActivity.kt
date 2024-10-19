package com.example.rmom

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.rmom.databinding.ActivityMainBinding
import io.realm.Realm

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        realm = Realm.getInstance(Realm.getDefaultConfiguration())

        binding.btninsert.setOnClickListener {

            var name = binding.edtname.text.toString()
            var num = binding.edtnum.text.toString()

            realm.executeTransaction { transactionRealm ->
                val nextId = (transactionRealm.where(Model::class.java).max("id")?.toInt() ?: 0) + 1
                val model = transactionRealm.createObject(Model::class.java, nextId) // Set unique id
                model.name = name
                model.num = num
            }

//            realm.beginTransaction()
//
//                var m = realm.createObject(Model::class.java)
//                m.name=name
//                m.num=num
//
//            realm.commitTransaction()

            Toast.makeText(applicationContext, "Inserted", Toast.LENGTH_SHORT).show()

        }


    }
}