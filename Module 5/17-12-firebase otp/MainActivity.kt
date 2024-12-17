package com.example.firebaseotpex

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity()
{
    lateinit var edtPhone: EditText
    lateinit var edtOtp: EditText
    lateinit var btn1: Button
    lateinit var btn2: Button
    private lateinit var auth: FirebaseAuth
    lateinit var mcallback: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    lateinit var verificationid: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtPhone = findViewById(R.id.edt1)
        edtOtp = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        auth = FirebaseAuth.getInstance()


        btn1.setOnClickListener {


            var mob = edtPhone.text.toString()
            sendverificationcode(mob)

        }
        btn2.setOnClickListener {


            val otp: String = edtOtp.text.toString()
            verifycode(otp)
        }


    mcallback = object :PhoneAuthProvider.OnVerificationStateChangedCallbacks()
        {
            override fun onVerificationCompleted(p0: PhoneAuthCredential)
            {
                var code =p0.smsCode

                if(code!=null)
                {
                    edtOtp.setText(code)
                }
                else
                {
                    Toast.makeText(applicationContext,"Error  ", Toast.LENGTH_LONG).show();
                }
                     }

            override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken)
            {
                verificationid=p0
            }

            override fun onVerificationFailed(p0: FirebaseException)
            {
                Toast.makeText(applicationContext,"Failed "+p0.message,Toast.LENGTH_LONG).show()
            }

        }

    }

    private fun sendverificationcode(mob: String)
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(mob,60, TimeUnit.SECONDS,this,mcallback)

    }
    private fun verifycode(otp: String)
    {
        val credential = PhoneAuthProvider.getCredential(verificationid, otp)
        signinwithcredential(credential)
    }

    private fun signinwithcredential(credential: PhoneAuthCredential)
    {
        auth.signInWithCredential(credential).addOnCompleteListener {
            if(it.isSuccessful)
            {
                var i = Intent(this,MainActivity2::class.java)
                startActivity(i)
            }
            else
            {
                Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
            }
        }
            .addOnFailureListener()
            {

            }

    }
}
