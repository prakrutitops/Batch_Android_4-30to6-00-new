package com.example.tablayoutex1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView


class ChatFragment : Fragment()
{
    lateinit var listView: ListView
    lateinit var list:MutableList<Model>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       var view =inflater.inflate(R.layout.fragment_chat, container, false)

        listView = view.findViewById(R.id.list)
        list = ArrayList()

        list.add(Model(R.drawable.a1,"Abcd"))
        list.add(Model(R.drawable.a2,"PQRS"))

        var adapter = MyAdapter2(requireActivity(),list)
        listView.adapter=adapter

        return view
    }


}