package com.example.uicomponentex

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView
import java.util.Date

class MainActivity : AppCompatActivity()
{
    lateinit var sliderLayout: SliderLayout
    var map = HashMap<String,Int>()
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var auto:AutoCompleteTextView
    var city = arrayOf("rajkot","ahmedabad","baroda")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sliderLayout = findViewById(R.id.slider)
        auto = findViewById(R.id.auto1)

        auto.threshold=1
        var adapter = ArrayAdapter(applicationContext,android.R.layout.select_dialog_item,city)
        auto.setAdapter(adapter)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)

        map.put("Pizza",R.drawable.pizza)
        map.put("Burger",R.drawable.burger)
        map.put("Coffee",R.drawable.coffee)

        for(i in map.keys)
        {
            var txtslider = TextSliderView(this)
            txtslider.image(map.get(i)!!)

            sliderLayout.addSlider(txtslider)
        }
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.FlipPage)
        //sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.)
        //sliderLayout.setDuration(3000)


        btn1.setOnClickListener {

            var d = DateFragment()
            d.show(supportFragmentManager,"")

        }
        btn2.setOnClickListener {

            var d = TimeFragment()
            d.show(supportFragmentManager,"")


        }


    }


}