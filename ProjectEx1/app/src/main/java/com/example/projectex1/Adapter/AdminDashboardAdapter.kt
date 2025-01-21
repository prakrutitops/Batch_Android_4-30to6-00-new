package com.example.projectex1.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.projectex1.Model.AdminDashboardModel
import com.example.projectex1.R


class AdminDashboardAdapter(var context: Context, var list:MutableList<AdminDashboardModel>) : BaseAdapter()
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
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
       var layoutInflater = LayoutInflater.from(context)
        var view = layoutInflater.inflate(R.layout.design_admin_dashboard,parent,false)

        var image: ImageView = view.findViewById(R.id.img)
        var text: TextView = view.findViewById(R.id.txt)

        image.setImageResource(list.get(position).image)
        text.setText(list.get(position).name)

        return view
    }

}