package com.example.projectex1.Activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projectex1.R
import com.example.projectex1.databinding.ActivityPaymentBinding
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import com.squareup.picasso.Picasso
import org.json.JSONException
import org.json.JSONObject

class PaymentActivity : AppCompatActivity(), PaymentResultListener
{
    lateinit var binding: ActivityPaymentBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentBinding.inflate(layoutInflater)
        val view = binding.root
        //sharedPreferences = getSharedPreferences("Session", Context.MODE_PRIVATE)
        binding.toolBar.title = "Payment"
        setSupportActionBar(binding.toolBar)
        binding.toolBar.setNavigationOnClickListener {
            super.finish()
        }
        setContentView(view)

        val intent = intent
        val pName = intent.getStringExtra("pName")
        val pPrice = intent.getStringExtra("pPrice")
        val pDesc = intent.getStringExtra("pDesc")
        val pImage = intent.getStringExtra("pImage")

        Picasso.get().load(pImage).into(binding.imageView)
        binding.tvName.text = pName
        binding.tvPrice.text = pPrice
        binding.tvDesc.text = pDesc

        binding.paymentBtn.setOnClickListener {

            val price = Integer.parseInt(pPrice!!) * 100

            val checkout = Checkout()
            checkout.setKeyID("rzp_test_pJ8ElvmChXIyZC")
            val obj = JSONObject()
            try {
                obj.put("name", pName)
                obj.put("description", "Test Payment")
                obj.put("theme.color", "")
                obj.put("currency", "INR")
                obj.put("amount", price)
                obj.put("prefill.contact", "8849490169")
                obj.put("prefill.email", "a@gmail.com")

                checkout.open(this, obj)
            } catch (e: JSONException) {
                e.printStackTrace()
            }


        }

    }

    override fun onPaymentSuccess(p0: String?)
    {
        Toast.makeText(this, "Payment Success", Toast.LENGTH_SHORT).show()



        //Entry Table
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this, "Payment Failed :-  $p0 : $p1", Toast.LENGTH_SHORT).show()    }

}