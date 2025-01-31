package com.example.socialmedialoginex

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.FacebookSdk
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton

class MainActivity2 : AppCompatActivity()
{
    lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FacebookSdk.sdkInitialize(getApplicationContext())
        setContentView(R.layout.activity_main2)

        callbackManager = CallbackManager.Factory.create ()
        val loginButton = findViewById<LoginButton>(R.id.login_button)
        loginButton.setReadPermissions("email", "public_profile")
        loginButton.registerCallback(callbackManager,object: FacebookCallback<LoginResult> {

            override fun onSuccess(result: LoginResult?)
            {
                val accessToken: AccessToken = result!!.getAccessToken()
                Toast.makeText(applicationContext, ""+accessToken, Toast.LENGTH_SHORT).show()

            //startactivity
                // accessToken.

            }

            override fun onCancel() {

            }

            override fun onError(error: FacebookException?) {

            }
        })

    }
}