package com.example.projectex1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectex1.Activity.CategoryViewActivity
import com.example.projectex1.Model.DashboardModel
import com.example.projectex1.Model.Payment
import com.squareup.picasso.Picasso

class PaymentViewAdapter(var context: Context,var list: MutableList<Payment>):RecyclerView.Adapter<MyViewP>()


{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewP {
        var  layoutInflater= LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.admin_paymentview_design,parent,false)
        return MyViewP(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewP , position: Int)
    {
        holder.textView.setText(list.get(position).pname)
        holder.textView2.setText(list.get(position).pprice)
        holder.textView3.setText(list.get(position).pdes)
        holder.textView4.setText(list.get(position).mobile)
        Picasso.get().load(list.get(position).pimage).into(holder.imageview2)


    }
}
class MyViewP(Itemview:View):RecyclerView.ViewHolder(Itemview)
{
    var textView: TextView = Itemview.findViewById(R.id.txt1)
    var textView2: TextView = Itemview.findViewById(R.id.txt2)
    var textView3: TextView = Itemview.findViewById(R.id.txt3)
    var textView4: TextView = Itemview.findViewById(R.id.txt4)
    var imageview2: ImageView = Itemview.findViewById(R.id.img)




}