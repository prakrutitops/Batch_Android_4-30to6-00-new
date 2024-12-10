package com.example.retrfotimageupload

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.READ_MEDIA_IMAGES
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File


class MainActivity : AppCompatActivity() {

    lateinit var edt1: EditText
    lateinit var edt2: EditText
    lateinit var edt3: EditText
    lateinit var edt4: EditText
    lateinit var btn1: Button
    lateinit var imageview: ImageView
    lateinit var filepath: Uri
    lateinit var bitmap: Bitmap
    lateinit var apiinterface: Apiinterface

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.name)
        edt2 = findViewById(R.id.price)
        edt3 = findViewById(R.id.des)
        edt4 = findViewById(R.id.status)
        btn1 = findViewById(R.id.btn_regi)
        imageview = findViewById(R.id.img)
        apiinterface = ApiClient.getapiclient().create(Apiinterface::class.java)
        permissions()



        imageview.setOnClickListener {

            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 1)


        }

        btn1.setOnClickListener {

            filepath?.let { uri ->
                val filePath = getpath(uri)
                if (filePath != null)
                {
                    uploadImage(filePath)
                }
            }
        }

    }

    //permission code start

    private fun permissions() {
        if (ContextCompat.checkSelfPermission(
                this,
                READ_MEDIA_IMAGES
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(READ_MEDIA_IMAGES), 100)
        } else {
            Toast.makeText(applicationContext, "Permission already granted", Toast.LENGTH_LONG)
                .show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
        }
    }


    //permission code end


    private fun uploadImage(filePath: String) {
        val name = edt1.text.toString()
        val price = edt2.text.toString()
        val des = edt3.text.toString()
        val status = edt4.text.toString()

        // Create the RequestBody for the other form data fields
        val name1: RequestBody = RequestBody.create(MultipartBody.FORM, name)
        val price1: RequestBody = RequestBody.create(MultipartBody.FORM, price)
        val des1: RequestBody = RequestBody.create(MultipartBody.FORM, des)
        val status1: RequestBody = RequestBody.create(MultipartBody.FORM, status)

        // Get the actual image file from the URI
        val file = File(filePath)

        // Create RequestBody for the image file
        val requestFile: RequestBody = RequestBody.create(contentResolver.getType(filepath)!!.toMediaTypeOrNull(), file)

        // Create MultipartBody.Part for the image
        val body: MultipartBody.Part = MultipartBody.Part.createFormData("pimage", file.name, requestFile)

        // Make the Retrofit API call
        val call: Call<ResponseBody?>? = apiinterface.uploaddata(name1, price1, des1, status1, body)

        call!!.enqueue(object : Callback<ResponseBody?> {
            override fun onResponse(call: Call<ResponseBody?>?, response: Response<ResponseBody?>?) {
                if (response!!.isSuccessful) {
                    Toast.makeText(applicationContext, "Upload Success", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(applicationContext, "Upload Failed: ${response.message()}", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
                Toast.makeText(applicationContext, "Fail: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }



    //    private fun uploadImage(filePath: String) {
//        var name = edt1.text.toString()
//        var price = edt2.text.toString()
//        var des = edt3.text.toString()
//        var status = edt4.text.toString()
//
//
//        // val name1: RequestBody = create(MultipartBody.FORM,name)
//        val name1: RequestBody = RequestBody.Companion.create(MultipartBody.FORM, name)
//        val price1: RequestBody = RequestBody.Companion.create(MultipartBody.FORM, price)
//        val des1: RequestBody = RequestBody.Companion.create(MultipartBody.FORM, des)
//        val status1: RequestBody = RequestBody.Companion.create(MultipartBody.FORM, status)
//
//        var file = getpath(filePath)!!
//
//        val requestFile: RequestBody = RequestBody.Companion.create(contentResolver.getType(filepath)!!.toMediaTypeOrNull(), file)
//
//        val body = MultipartBody.Part.createFormData("pimage", file.name, requestFile)
//
//
//
//    var call: Call<ResponseBody?>? = apiinterface.uploaddata(name1, price1, des1, status1, body)
//
//    call!!.enqueue(
//    object : Callback<ResponseBody?> {
//        override fun onResponse(
//            call: Call<ResponseBody?>,
//            response: Response<ResponseBody?>
//        ) {
//
//            Toast.makeText(applicationContext, "Success " + body, Toast.LENGTH_LONG).show()
//
//        }
//
//        override fun onFailure(call: Call<ResponseBody?>, t: Throwable) {
//
//            Toast.makeText(applicationContext, "Fail", Toast.LENGTH_LONG).show()
//
//        }
//
//    })
//}
    private fun getpath(uri: Uri): String? {
        val cursor: Cursor? = contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            it.moveToFirst()
            val columnIndex = it.getColumnIndex(MediaStore.Images.Media.DATA)
            if (columnIndex != -1) {
                return it.getString(columnIndex)
            }
        }
        return null
    }





    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null)
        {
            filepath= data.data!!
            imageview.setImageURI(filepath)
        }

        super.onActivityResult(requestCode, resultCode, data)
    }
}