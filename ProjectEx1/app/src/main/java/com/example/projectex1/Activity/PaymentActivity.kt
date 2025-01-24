package com.example.projectex1.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.classproject.clients.ApiClient
import com.example.classproject.interfaces.ApiInterface
import com.example.projectex1.LoginActivity
import com.example.projectex1.R
import com.example.projectex1.databinding.ActivityPaymentBinding
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import com.squareup.picasso.Picasso
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaymentActivity : AppCompatActivity(), PaymentResultListener
{
    lateinit var binding: ActivityPaymentBinding
    lateinit var sharedPreferences: SharedPreferences
    var mob=""
    var pName=""
    var pPrice=""
    var pDesc=""
    var pImage=""
    lateinit var apiinterface: ApiInterface
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
         pName = intent.getStringExtra("pName").toString()
         pPrice = intent.getStringExtra("pPrice").toString()
         pDesc = intent.getStringExtra("pDesc").toString()
         pImage = intent.getStringExtra("pImage").toString()
        sharedPreferences = getSharedPreferences("user_session", Context.MODE_PRIVATE)
        Toast.makeText(applicationContext,"Welcome "+sharedPreferences.getString("mob",""), Toast.LENGTH_LONG).show()

        mob = sharedPreferences.getString("mob","").toString()

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

        apiinterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)

        val registercall: Call<Void> = apiinterface.paymentadd(pName,pPrice,pDesc,pImage,mob)
        registercall.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {

                startActivity(Intent(applicationContext, LoginActivity::class.java))
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG)
                    .show()
            }
        })

        //Entry Table
    }

    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this, "Payment Failed :-  $p0 : $p1", Toast.LENGTH_SHORT).show()    }

}