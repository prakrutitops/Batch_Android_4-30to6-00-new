package com.example.tablayoutex1

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyAdapter(context:Context,fm:FragmentManager) : FragmentStatePagerAdapter(fm)
{
     var listfragment:ArrayList<Fragment> = ArrayList()
    var listtitle:ArrayList<String> = ArrayList()


    override fun getCount(): Int
    {
        return  listtitle.size
    }

    override fun getItem(position: Int): Fragment
    {
        return  listfragment.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence?
    {
        return listtitle.get(position)
    }

    fun tops(title:String,fragment: Fragment)
    {
        listtitle.add(title)
        listfragment.add(fragment)
    }



}