package com.example.firebasecrudex


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions


class MyAdapter(options: FirebaseRecyclerOptions<Model>) : FirebaseRecyclerAdapter<Model,MyView>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
        var inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.design,parent,false)
        return  MyView(inflater)
    }

    override fun onBindViewHolder(holder: MyView, position: Int, model: Model)
    {
        holder.name.setText(model.name)
        holder.num.setText(model.num)
        holder.email.setText(model.email)

    }
}

class MyView(itemview: View) : RecyclerView.ViewHolder(itemview)
{
    var name:TextView
    var num:TextView
    var email:TextView

    init
    {
        name = itemView.findViewById(R.id.txt1)
        email = itemView.findViewById(R.id.txt2)
        num = itemView.findViewById(R.id.txt3)
    }

}