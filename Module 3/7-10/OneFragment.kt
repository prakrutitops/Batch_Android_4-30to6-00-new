package com.example.expandableex2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.expandableex2.ExpandableListDataPump.data


class OneFragment : Fragment() {

    var expandableListView: ExpandableListView? = null
    var expandableListAdapter: ExpandableListAdapter? = null
    var expandableListTitle: List<String>? = null
    var expandableListDetail: HashMap<String, List<String>>? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        var view =inflater.inflate(R.layout.fragment_one, container, false)

        expandableListView = view.findViewById(R.id.expandableListView) as ExpandableListView
        expandableListDetail = data
        expandableListTitle = ArrayList(expandableListDetail!!.keys)

        expandableListAdapter = CustomExpandableListAdapter(requireContext(), expandableListTitle!!, expandableListDetail!!)
        expandableListView!!.setAdapter(expandableListAdapter)

        expandableListView!!.setOnGroupCollapseListener { groupPosition ->
            Toast.makeText(requireContext(), expandableListTitle!!.get(groupPosition) + " List Collapsed.", Toast.LENGTH_SHORT).show()
        }

        expandableListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            Toast.makeText(
                requireContext(), expandableListTitle!!.get(groupPosition)
                        + " -> "
                        + expandableListDetail!![expandableListTitle!!.get(groupPosition)]!![childPosition],
                Toast.LENGTH_SHORT
            ).show()
            false
        }

        return view
    }


}