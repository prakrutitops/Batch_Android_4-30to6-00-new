package com.example.jsonparseex11

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class MainActivity : AppCompatActivity()
{
    lateinit var f1:FloatingActionButton
    lateinit var listView: ListView
    lateinit var list:MutableList<Model>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        f1 = findViewById(R.id.f1)

        listView = findViewById(R.id.list)
        list = ArrayList()
        registerForContextMenu(listView)
        var stringrequest = StringRequest(
            Request.Method.GET,
            "https://prakrutitech.buzz/CRUD/view.php",
            object : Response.Listener<String> {
                override fun onResponse(response: String?) {

                    var jsonarray = JSONArray(response)
                    for (i in 0 until jsonarray.length()) {
                        var jsonobject = jsonarray.getJSONObject(i)

                        var id = jsonobject.getString("id")
                        var name = jsonobject.getString("name")
                        var surname = jsonobject.getString("surname")
                        var email = jsonobject.getString("email")

                        var m = Model()
                        m.id = id
                        m.name = name
                        m.surname = surname
                        m.email = email


                        list.add(m)

                    }
                    var myadapter = MyAdapter(applicationContext, list)
                    listView.adapter = myadapter

                }
            },
            object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError?) {
                    Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()
                }
            })

        var queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringrequest)


        f1.setOnClickListener {

            var i = Intent(applicationContext, AdduserActivity::class.java)
            startActivity(i)
        }

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1 = menu!!.add(0,1,0,"Update")
        var m2 = menu!!.add(0,2,0,"Delete")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {

        var acm:AdapterContextMenuInfo  = item.menuInfo as AdapterContextMenuInfo
        var id =acm.position
        var m = list[id]

        when(item.itemId)
        {
            1->
            {
                    var i = Intent(applicationContext,UpdateAcitivity::class.java)
                    i.putExtra("myid",m.id)
                    i.putExtra("myname",m.name)
                    i.putExtra("mysurname",m.surname)
                    i.putExtra("myemail",m.email)
                    startActivity(i)
            }
            2->
            {
                var alert = AlertDialog.Builder(this)
                alert.setTitle("Are you sure you want to delete?")
                alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

                    var stringrequest:StringRequest = object :StringRequest(Request.Method.POST,"https://prakrutitech.buzz/CRUD/delete.php",
                        Response.Listener {

                            Toast.makeText(applicationContext,"Deleted",Toast.LENGTH_LONG).show()
                            startActivity(Intent(applicationContext,MainActivity::class.java))

                        },Response.ErrorListener {

                            Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()

                        })


                    {
                        override fun getParams(): MutableMap<String, String>?
                        {
                            var map = HashMap<String,String>()
                            map["id"]= m.id
                            return map
                        }

                    }
                    var queue:RequestQueue = Volley.newRequestQueue(this)
                    queue.add(stringrequest)


                })
                alert.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

                })
                alert.show()
            }
        }






        return super.onContextItemSelected(item)
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}