package com.example.customlistex

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var context:Context,var list: MutableList<Model>) : BaseAdapter()
{
    override fun getCount(): Int
    {
        return list.size
    }

    override fun getItem(position: Int): Any
    {
        return position
    }

    override fun getItemId(position: Int): Long
    {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        var layout = LayoutInflater.from(context)
        var view = layout.inflate(R.layout.design,parent,false)

        var img:ImageView = view.findViewById(R.id.img)
        var txt:TextView = view.findViewById(R.id.txt1)
        var txt2:TextView = view.findViewById(R.id.txt2)

        //get model
        img.setImageResource(list.get(position).image)
        txt.setText(list.get(position).text1)
        txt2.setText(list.get(position).text2)

        img.setOnClickListener {

            var i = Intent(context,SecondActivity::class.java)
            i.putExtra("pos",position)
            context.startActivity(i)
        }

        return view
    }

}