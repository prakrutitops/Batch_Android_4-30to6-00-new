package com.example.tablayoutex1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity()
{
    lateinit var toolbar: Toolbar
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        toolbar = findViewById(R.id.tool)
        setSupportActionBar(toolbar)

        viewPager = findViewById(R.id.viewpager)
        setupviewpager()

        tabLayout = findViewById(R.id.tab)
        tabLayout.setupWithViewPager(viewPager)


    }

    private fun setupviewpager()
    {
        var adapter = MyAdapter(applicationContext,supportFragmentManager)
       //set
        adapter.tops("CHAT",ChatFragment())
        adapter.tops("STATUS",StatusFragment())
        adapter.tops("CALL",CallFragment())
        viewPager.adapter=adapter

    }
}