package com.example.realmex1

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import io.realm.Realm

class ViewActivity : AppCompatActivity(), AdapterView.OnItemLongClickListener {

    lateinit var listView: ListView
    lateinit var list:MutableList<Model>
    lateinit var realm: Realm
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view)

        listView = findViewById(R.id.list)
        list = ArrayList()
        realm = Realm.getInstance(Realm.getDefaultConfiguration())

        realm.beginTransaction()

           var realmresults = realm.where(Model::class.java).findAll()

            for(i in realmresults.indices)
            {
                    list.add(realmresults[i]!!)
            }

            var adapter = MyAdapter(applicationContext,list)
            listView.adapter=adapter


        realm.commitTransaction()

        listView.setOnItemLongClickListener(this)
    }

    @SuppressLint("MissingInflatedId")
    override fun onItemLongClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long): Boolean
    {

        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Select Operations?")
        alertDialog.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->


            var alert2 = AlertDialog.Builder(this)
            var inflater= LayoutInflater.from(this)
            var view =inflater.inflate(R.layout.activity_update,null)
            var edit1: EditText =view.findViewById(R.id.edtname)
            var edit2:EditText =view.findViewById(R.id.edtnum)

            edit1.setText(list.get(p2).name)
            edit2.setText(list.get(p2).num)
            alert2.setView(view)
            alert2.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->

                    realm.beginTransaction()
                    var name = edit1.text.toString()
                    var num = edit2.text.toString()

                    list.get(p2).name =name
                    list.get(p2).num =num

                    realm.commitTransaction()
                    startActivity(Intent(this,ViewActivity::class.java))



            })
//

            alert2.show()

        })
        alertDialog.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->

            realm.beginTransaction()

            var deleterealm = realm.where(Model::class.java).findAll()
            deleterealm.deleteFromRealm(p2)
            realm.commitTransaction()
            startActivity(Intent(applicationContext,ViewActivity::class.java))


        })
        alertDialog.show()


        return false
    }
}