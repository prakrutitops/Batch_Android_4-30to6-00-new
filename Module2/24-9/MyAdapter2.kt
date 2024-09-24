package com.example.tablayoutex1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter2(var context:Context,var list:MutableList<Model>) : BaseAdapter()
{
    override fun getCount(): Int
    {
        return list.size
    }

    override fun getItem(position: Int): Any
    {
        return list.get(position)
    }

    override fun getItemId(position: Int): Long
    {
        return  position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.design_chat,parent,false)

        var image:ImageView = view.findViewById(R.id.profile_image)
        var text:TextView = view.findViewById(R.id.txt1)

        image.setImageResource(list.get(position).image)
        text.setText(list.get(position).title)


        return view

    }

}