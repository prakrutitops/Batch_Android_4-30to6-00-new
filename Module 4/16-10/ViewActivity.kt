package com.example.test45

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
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

        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1: MenuItem = menu!!.add(0,1,0,"update")
        var m2: MenuItem = menu!!.add(0,2,0,"delete")

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm: AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var id = acm.position//pos
        var id2 = list.get(id).id//data

        when(item.itemId)
        {
            1->
            {
                var i = Intent(applicationContext,UpdateActivity::class.java)
                    i.putExtra("id",list.get(id).id)
                    i.putExtra("name",list.get(id).name)
                    i.putExtra("num",list.get(id).num)
                    i.putExtra("pass",list.get(id).pass)
                startActivity(i)
            }
            2->
            {

                var alert = AlertDialog.Builder(this)
                alert.setTitle("Are you sure you want to delete?")
                alert.setPositiveButton("YES",
                    { dialogInterface: DialogInterface, i: Int ->


                        //Toast.makeText(app, "", Toast.LENGTH_SHORT).show()
                        dbHelper.deletedata(id2)
                        startActivity(Intent(applicationContext,ViewActivity::class.java))

                    })
                alert.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->


                        dialogInterface.cancel()

                })
                alert.show()


            }
        }

        return super.onContextItemSelected(item)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}