package com.example.menuex

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity()
{
    lateinit var toolbar: Toolbar
    lateinit var listView: ListView
    lateinit var list:MutableList<String>
    lateinit var btn1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        toolbar = findViewById(R.id.tool)
        setSupportActionBar(toolbar)

        listView = findViewById(R.id.list)
        list = ArrayList()

        btn1 = findViewById(R.id.btn1)


        btn1.setOnClickListener {

            var popupmenu = PopupMenu(applicationContext,btn1)
            popupmenu.menuInflater.inflate(R.menu.popup_menu,popupmenu.menu)
            //popupmenu.setOnMenuItemClickListener(this)
            popupmenu.show()




        }


        list.add("Abcd")
        list.add("Abcd")
        list.add("Abcd")
        list.add("Abcd")
        list.add("Abcd")
        list.add("Abcd")

        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,list)
        listView.adapter=adapter

        registerForContextMenu(listView)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.option_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.i1->
            {
                Toast.makeText(applicationContext, "About us called", Toast.LENGTH_SHORT).show()
            }
            R.id.i2->
            {
                var num="9988998899"
                var i = Intent(Intent.ACTION_CALL)
                i.setData(Uri.parse("tel:"+num))
                startActivity(i)

                //Toast.makeText(applicationContext, "Contact us called", Toast.LENGTH_SHORT).show()

            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.context_menu,menu)

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {

        var acm:AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo

        when(item.itemId)
        {
            R.id.i1->
            {
                Toast.makeText(applicationContext, ""+acm.position, Toast.LENGTH_SHORT).show()
            }
        }
        return super.onContextItemSelected(item)
    }



}