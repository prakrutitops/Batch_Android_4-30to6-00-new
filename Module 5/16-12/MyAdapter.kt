package com.example.firebasecrudex


import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.ViewHolder


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

        holder.img1.setOnClickListener {

            val dialogPlus = DialogPlus.newDialog(holder.img1.context)
                .setContentHolder(ViewHolder(R.layout.dialogcontent))
                .setExpanded(true, 1100)
                .create()

            val myview = dialogPlus.holderView
            val name = myview.findViewById<EditText>(R.id.uname)
            val num = myview.findViewById<EditText>(R.id.ucourse)
            val email = myview.findViewById<EditText>(R.id.uemail)
            val submit = myview.findViewById<Button>(R.id.usubmit)

            name.setText(model.name)
            num.setText(model.num)
            email.setText(model.email)

            submit.setOnClickListener {

                var map = HashMap<String,Any>()
                map["name"]=name.text.toString()
                map["email"]=email.text.toString()
                map["num"]=num.text.toString()

                var db = FirebaseDatabase.getInstance()
                    .getReference()
                    .child("tops")
                    .child(getRef(position).getKey()!!)
                    .updateChildren(map)
                    .addOnSuccessListener {

                        Toast.makeText(holder.img1.context,"Success",Toast.LENGTH_LONG).show()
                        dialogPlus.dismiss()
                    }
                    .addOnFailureListener {
                        Toast.makeText(holder.img1.context,"Error",Toast.LENGTH_LONG).show()
                    }


            }


            dialogPlus.show()






        }



        holder.img2.setOnClickListener {

            var alert = AlertDialog.Builder(holder.img2.context)
            alert.setTitle("DELETE?")
            alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

                FirebaseDatabase.getInstance().getReference().child("tops")
                    .child(getRef(position).getKey()!!)
                    .removeValue()

                notifyItemRangeChanged(position,0)


            })
            alert.setNegativeButton("No",{ dialogInterface: DialogInterface, i: Int ->

                dialogInterface.cancel()


            })
            alert.show()



        }

    }
}

class MyView(itemview: View) : RecyclerView.ViewHolder(itemview)
{
    var name:TextView
    var num:TextView
    var email:TextView
    var img1: ImageView
    var img2:ImageView

    init
    {
        name = itemView.findViewById(R.id.txt1)
        email = itemView.findViewById(R.id.txt2)
        num = itemView.findViewById(R.id.txt3)
        img1 = itemView.findViewById(R.id.imgupdate)
        img2 = itemView.findViewById(R.id.imgdelete)
    }

}