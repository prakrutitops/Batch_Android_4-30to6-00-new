package com.example.jsonwithfragment

import android.content.DialogInterface
import android.os.Bundle
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class ViewFragment : Fragment() {


    lateinit var listView: ListView
    lateinit var list:MutableList<Model>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_view, container, false)

        listView = view.findViewById(R.id.list)
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
                    var myadapter = MyAdapter(activity!!, list)
                    listView.adapter = myadapter

                }
            },
            object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError?) {
                    Toast.makeText(activity, "No Internet", Toast.LENGTH_LONG).show()
                }
            })

        var queue: RequestQueue = Volley.newRequestQueue(activity)
        queue.add(stringrequest)


        return view
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    )
    {
        var m1 = menu!!.add(0,1,0,"Update")
        var m2 = menu!!.add(0,2,0,"Delete")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {

        var acm: AdapterView.AdapterContextMenuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo
        var id =acm.position
        var m = list[id]

        when(item.itemId)
        {
            1->
            {
                //update
            }
            2->
            {
                var alert = AlertDialog.Builder(requireActivity())
                alert.setTitle("Are you sure you want to delete?")
                alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

                    var stringrequest:StringRequest = object :StringRequest(Request.Method.POST,"https://prakrutitech.buzz/CRUD/delete.php",
                        Response.Listener {

                            Toast.makeText(activity,"Deleted",Toast.LENGTH_LONG).show()
                            var view = ViewFragment()
                            var fm = fragmentManager
                            var ft = fm!!.beginTransaction()
                            ft.replace(R.id.nav_host_fragment_activity_main2,view).commit()
                            //startActivity(Intent(applicationContext,MainActivity::class.java))

                        },Response.ErrorListener {

                            Toast.makeText(activity,"Error",Toast.LENGTH_LONG).show()

                        })


                    {
                        override fun getParams(): MutableMap<String, String>?
                        {
                            var map = HashMap<String,String>()
                            map["id"]= m.id
                            return map
                        }

                    }
                    var queue:RequestQueue = Volley.newRequestQueue(activity)
                    queue.add(stringrequest)


                })
                alert.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

                })
                alert.show()
            }
        }






        return super.onContextItemSelected(item)
    }

}