package com.example.jsonwithfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


class InsertFragment : Fragment() {

    lateinit var edt1: EditText
    lateinit var edt2:EditText
    lateinit var edt3:EditText
    lateinit var edt4:EditText
    lateinit var btn1: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_insert, container, false)

        edt1 = view.findViewById(R.id.ename)
        edt2 = view.findViewById(R.id.esurname)
        edt3 = view.findViewById(R.id.eemail)
        edt4 = view.findViewById(R.id.epass)
        btn1 = view.findViewById(R.id.btn1)

        btn1.setOnClickListener {

            var n = edt1.text.toString()
            var s = edt2.text.toString()
            var e = edt3.text.toString()
            var p = edt4.text.toString()


            var stringrequest = object: StringRequest(
                Request.Method.POST,"https://prakrutitech.buzz/CRUD/insert.php",
                Response.Listener
                {
                    Toast.makeText(activity,"Inserted",Toast.LENGTH_LONG).show()

                    var view = ViewFragment()
                    var fm = fragmentManager
                    var ft = fm!!.beginTransaction()
                    ft.replace(R.id.nav_host_fragment_activity_main2,view).commit()

                   // startActivity(Intent(activity,MainActivity::class.java))
                },
                Response.ErrorListener
                {
                    Toast.makeText(activity,"Error",Toast.LENGTH_LONG).show()
                })
            {
                override fun getParams(): MutableMap<String, String>?
                {

                    var map = HashMap<String,String>()
                    map["name"] = n
                    map["surname"] = s
                    map["email"] = e
                    map["password"] = p

                    return map
                }
            }


            var queue: RequestQueue = Volley.newRequestQueue(activity)
            queue.add(stringrequest)
        }





        return view
    }


}