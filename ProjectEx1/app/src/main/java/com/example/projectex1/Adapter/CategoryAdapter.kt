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
class CategoryAdapter(var context: Context, private var list: MutableList<CategoryModel>) : RecyclerView.Adapter<MyCategoryView>() {

    private var filteredList: MutableList<CategoryModel> = list // this is the list that will be shown in the RecyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCategoryView {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.design_categoryview, parent, false)
        return MyCategoryView(view)
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun onBindViewHolder(holder: MyCategoryView, position: Int) {
        holder.textView.text = filteredList[position].name
        holder.textView2.text = filteredList[position].description
        holder.textView3.text = filteredList[position].price
        Picasso.get().load(filteredList[position].url).into(holder.imageview2)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, FullScreenActivity::class.java)
            intent.putExtra("image", filteredList[position].url)
            intent.putExtra("name", filteredList[position].name)
            intent.putExtra("desc", filteredList[position].description)
            intent.putExtra("price", filteredList[position].price)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        }
    }

    fun updateList(filteredList: List<CategoryModel>) {
        this.filteredList = filteredList.toMutableList()
        notifyDataSetChanged()
    }
}

class MyCategoryView(Itemview: View) : RecyclerView.ViewHolder(Itemview) {
    var textView: TextView = Itemview.findViewById(R.id.category_txt)
    var imageview2: ImageView = Itemview.findViewById(R.id.category_img)
    var textView2: TextView = Itemview.findViewById(R.id.category_desc)
    var textView3: TextView = Itemview.findViewById(R.id.category_price)
}
