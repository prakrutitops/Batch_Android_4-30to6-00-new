package com.example.roomdbex

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context,var list:MutableList<User>) : RecyclerView.Adapter<Myview>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview
    {
        var inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.design,parent,false)
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
            alert.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int -> })
            alert.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int -> })
            alert.show()
        }
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