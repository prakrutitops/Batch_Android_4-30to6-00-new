package com.example.socialmedialoginex

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.tasks.Task

class MainActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener {
    private val RC_SIGN_IN = 9001
    private var mGoogleApiClient: GoogleApiClient? = null
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.sign_in_button)

        btn.setOnClickListener {

            signInWithGoogle()

        }
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        mGoogleApiClient = GoogleApiClient.Builder(this)
            .enableAutoManage(this, this)
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            .build()

    }

    private fun signInWithGoogle()
    {
        val signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient)
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        if (requestCode === RC_SIGN_IN)
        {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun handleSignInResult(task: Task<GoogleSignInAccount>)
    {
        try {
            val account: GoogleSignInAccount = task.getResult(ApiException::class.java)
            Toast.makeText(applicationContext,""+account.email,Toast.LENGTH_LONG).show()
            //startActivity()
            var photo = account.photoUrl
            var name = account.displayName
            var email = account.email

            Log.d("photo",photo.toString())
            Log.d("name",name)
            Log.d("email",email)

            // You can access user information like account.getDisplayName(), account.getEmail(), etc.
            // You can also send this information to your server for authentication.

            // After successful login, you can navigate to the main activity or perform other actions.
        } catch (e: ApiException) {
            // Handle sign-in failure
            e.printStackTrace()
        }
    }

    override fun onConnectionFailed(p0: ConnectionResult)
    {
        Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()
    }
}