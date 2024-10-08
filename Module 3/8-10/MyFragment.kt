package com.example.expandableex2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.expandableex123.MyAdapter
import com.example.expandableex123.R
import com.example.expandableex2.ExpandableListDataPump.data


class MyFragment : Fragment() {

    var expandableListView: ExpandableListView? = null
    var expandableListAdapter: ExpandableListAdapter? = null
    var expandableListTitle: List<String>? = null
    var expandableListDetail: HashMap<String, List<String>>? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        var view =inflater.inflate(R.layout.fragment_my, container, false)

        expandableListView = view.findViewById(R.id.el) as ExpandableListView
        expandableListDetail = data

        expandableListTitle = ArrayList(expandableListDetail!!.keys)

        expandableListAdapter = MyAdapter(requireContext(), expandableListTitle!!, expandableListDetail!!)
        expandableListView!!.setAdapter(expandableListAdapter)



        return view
    }


}