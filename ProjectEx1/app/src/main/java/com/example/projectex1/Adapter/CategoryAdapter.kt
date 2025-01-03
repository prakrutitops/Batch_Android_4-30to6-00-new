package com.example.projectex1

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.classproject.clients.ApiClient
import com.example.classproject.interfaces.ApiInterface
import com.example.projectex1.Activity.FullScreenActivity
import com.example.projectex1.Model.CategoryModel
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CategoryAdapter(var context: Context,var list: MutableList<CategoryModel>):RecyclerView.Adapter<MyCategoryView>()


{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCategoryView {
        var  layoutInflater= LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.design_categoryview,parent,false)
        return MyCategoryView(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyCategoryView , position: Int)
    {
        holder.textView.setText(list.get(position).name)
        holder.textView2.setText(list.get(position).description)
        holder.textView3.setText(list.get(position).price)

        Picasso.get().load(list.get(position).url).into(holder.imageview2)

        holder.itemView.setOnClickListener {


            var intent = Intent(context, FullScreenActivity::class.java)
            intent.putExtra("image", list.get(position).url)
            intent.putExtra("name", list.get(position).name)
            intent.putExtra("desc", list.get(position).description)
            intent.putExtra("price", list.get(position).price)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)

        }
    }
}
class MyCategoryView(Itemview:View):RecyclerView.ViewHolder(Itemview)
{
    var textView: TextView = Itemview.findViewById(R.id.category_txt)
    var imageview2: ImageView = Itemview.findViewById(R.id.category_img)
    var textView2: TextView = Itemview.findViewById(R.id.category_desc)
    var textView3: TextView = Itemview.findViewById(R.id.category_price)



}