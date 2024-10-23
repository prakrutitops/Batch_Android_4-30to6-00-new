package com.example.roomdbex

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room

class MyAdapter(var context: Context,var list:MutableList<User>) : RecyclerView.Adapter<Myview>()
{
    lateinit var db:DatabaseClass

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview
    {
        var inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.design,parent,false)

        db = Room.databaseBuilder(parent.context, DatabaseClass::class.java, "myDatabase")
            .allowMainThreadQueries()
            .build()
        return Myview(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: Myview, position: Int)
    {
        holder.txt1.setText(list.get(position).name)
        holder.txt2.setText(list.get(position).email)

        holder.itemView.setOnClickListener {

            var alert = AlertDialog.Builder(holder.itemView.context)
            alert.setTitle("Select Operations?")
            alert.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->


                GlobalVariables.id=list.get(position).id
                GlobalVariables.name=list.get(position).name
                GlobalVariables.email=list.get(position).email
                GlobalVariables.updateFlag = "update"


                var i = Intent(context, AdduserActivity::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context!!.startActivity(i)



            })
            alert.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->


                deleteuser(list.get(position).id)
                var i = Intent(context,MainActivity::class.java)
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(i)

            })
            alert.show()
        }
    }

    fun deleteuser(id:Int)
    {
        val user = User()
        user.id = id
        db!!.daoClass().deletedata(user)
        Toast.makeText(context,"Deleted",Toast.LENGTH_LONG).show()
    }

}
class Myview(itemview: View) : RecyclerView.ViewHolder(itemview)
{
         lateinit var txt1:TextView
         var txt2:TextView
    init
    {
        txt1 = itemview.findViewById(R.id.txt1)
        txt2 = itemview.findViewById(R.id.txt2)
    }

}