package com.example.uploadimageex

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
import net.gotev.uploadservice.MultipartUploadRequest

class MainActivity : AppCompatActivity() {

    lateinit var edt1: EditText
    lateinit var btn2: Button
    lateinit var btn1: Button
    lateinit var imageview: ImageView
    lateinit var filepath: Uri
    lateinit var bitmap: Bitmap

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        btn2 = findViewById(R.id.btn2)
        btn1 = findViewById(R.id.btn1)
        imageview = findViewById(R.id.img)

        permissions()



        btn1.setOnClickListener {

            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 1)


        }

        btn2.setOnClickListener {

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
        if (ContextCompat.checkSelfPermission(this, READ_MEDIA_IMAGES) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(READ_MEDIA_IMAGES), 100)
        } else {
            Toast.makeText(applicationContext, "Permission already granted", Toast.LENGTH_LONG).show()
        }
    }
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
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

        try {
            val uploadRequest = MultipartUploadRequest(this,"https://prakrutitech.buzz/CRUD/upload.php")
                .addFileToUpload(filePath, "url")  // "file" is the field name on the server
                .addParameter("name", name)         // Add additional parameters if needed
                .setMaxRetries(2)

            uploadRequest.startUpload()
            Toast.makeText(applicationContext, "success", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("Upload", "Upload failed: ${e.message}")
        }
    }

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
