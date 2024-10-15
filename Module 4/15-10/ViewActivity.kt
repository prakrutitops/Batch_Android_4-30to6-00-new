package com.example.test45

import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewActivity : AppCompatActivity()
{

    lateinit var listView: ListView
    lateinit var list:MutableList<Model>
    var arraylist = ArrayList<HashMap<String,String?>>()
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        dbHelper = DbHelper(applicationContext)
        listView = findViewById(R.id.list)
        list = dbHelper.viewdata()

        Toast.makeText(applicationContext, ""+list.size, Toast.LENGTH_SHORT).show()


        for(i in list)
        {
            var hm = HashMap<String,String?>()
            hm["n1"]=i.name
            hm["n2"]=i.num
            arraylist.add(hm)
        }

        var fromarray = arrayOf("n1","n2")
        var toarray = intArrayOf(R.id.txtname,R.id.txtnum)

        var adapter = SimpleAdapter(applicationContext,arraylist,R.layout.design,fromarray,toarray)
        listView.adapter=adapter


    }
}