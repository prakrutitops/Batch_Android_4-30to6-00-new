package com.example.retrofitcrudex1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context, var list: MutableList<Model>) : RecyclerView.Adapter<MyView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
        var  layoutInflater= LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.design,parent,false)
        return MyView(view)
    }

    override fun getItemCount(): Int
    {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int)
    {
        holder.textView.setText(list.get(position).name)
        holder.textView2.setText(list.get(position).surname)
        holder.textView3.setText(list.get(position).email)
        holder.textView4.setText(list.get(position).password)


    }

}
class MyView(view: View) : RecyclerView.ViewHolder(view)
{
    var textView: TextView = view.findViewById(R.id.txt1)
    var textView2: TextView = view.findViewById(R.id.txt2)
    var textView3: TextView = view.findViewById(R.id.txt3)
    var textView4: TextView = view.findViewById(R.id.txt4)



}