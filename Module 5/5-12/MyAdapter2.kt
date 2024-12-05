package com.example.jsonex2


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MyAdapter2(var context: Context,var list: MutableList<Model2>):BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(p0: Int): Any {
        return list.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.design2,p2,false)

        var txt1:TextView = view.findViewById(R.id.itemname)
        var txt2:TextView = view.findViewById(R.id.itemprice)
        var txt3:TextView = view.findViewById(R.id.itemstatus)
        var txt4:TextView = view.findViewById(R.id.itemdesc)
        var img :ImageView = view.findViewById(R.id.itemimage)

        txt1.setText(list.get(p0).name)
        txt2.setText(list.get(p0).price)
        txt3.setText(list.get(p0).status)
        txt4.setText(list.get(p0).desc)
        Picasso.get().load(list.get(p0).image).into(img)


        return view
    }
}