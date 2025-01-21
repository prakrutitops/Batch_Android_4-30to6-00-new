package com.example.projectex1.Activity

import android.Manifest.permission.READ_MEDIA_IMAGES
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.classproject.clients.ApiClient
import com.example.classproject.interfaces.ApiInterface
import com.example.projectex1.CartModel
import com.example.projectex1.DashboardAdapter
import com.example.projectex1.DashboardAdapter2
import com.example.projectex1.Model.DashboardModel
import com.example.projectex1.Model.data2
import com.example.projectex1.R
import com.example.projectex1.databinding.ActivityAddProductBinding
import com.example.projectex1.databinding.ActivityCategoryViewBinding
import net.gotev.uploadservice.MultipartUploadRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddProductActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityAddProductBinding
    lateinit var filepath: Uri
    lateinit var bitmap: Bitmap
    lateinit var apiInterface: ApiInterface
    lateinit var list: MutableList<data2>
    var categoryNames = arrayOf("Select Category")
    var categoryid = arrayOf(0)
    var finalcid=0
    // var categoryNames= arrayOf("Select Category")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        permissions()

//        var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,mycategory)
//        binding.spin.adapter=adapter

        apiInterface = ApiClient.getapiclient()!!.create(ApiInterface::class.java)
        list = ArrayList()
        var call: Call<List<data2>> = apiInterface.dashboard_viewdata2()
        call.enqueue(object : Callback<List<data2>> {
            override fun onResponse(call: Call<List<data2>>, response: Response<List<data2>>) {
                // list = response.body() as MutableList<DashboardModel>
                if (response.isSuccessful) {
                    list = response.body() as MutableList<data2>

                    // Extract the category names
                    categoryNames = list.map { it.name }.toTypedArray()
                    categoryid = list.map { it.id }.toTypedArray()
                    //cid = list.map { it.id }.toTypedArray()
                    // cid2=cid.get(0)
                    //var adapter = ArrayAdapter(applicationContext,android.R.layout.simple_spinner_dropdown_item,categoryNames)


                    // Set up the Spinner
                    val adapter = ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_spinner_item,
                        categoryNames
                    )
                    val adapter2 = ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_spinner_item,
                        categoryid
                    )

                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                    binding.spin.adapter = adapter
                    binding.spin2.adapter = adapter2
                }

            }

            override fun onFailure(call: Call<List<data2>>, t: Throwable) {
                Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()
            }
        })
        binding.spin.setOnItemSelectedListener(this)
        binding.spin2.setOnItemSelectedListener(this)

        binding.img.setOnClickListener {

            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 1)

        }
        binding.btn1.setOnClickListener {

            filepath?.let { uri ->
                val filePath = getpath(uri)
                if (filePath != null) {
                    uploadImage(filePath)
                }
            }

        }

    }

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

    private fun uploadImage(filePath: String) {

        var name = binding.edtname.text.toString()
        var price = binding.edtprice.text.toString()
        var des = binding.edtdes.text.toString()

        try {
            val uploadRequest =
                MultipartUploadRequest(this, "https://prakrutitech.buzz/AndroidAPI/addproduct.php")
                    .addFileToUpload(filePath, "url")  // "file" is the field name on the server
                    .addParameter("name", name)
                    .addParameter("description", des)
                    .addParameter("price", price)
                    .addParameter("c_id", finalcid.toString()) // Add additional parameters if needed
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1 && resultCode == Activity.RESULT_OK && data != null) {
            filepath = data.data!!
            binding.img.setImageURI(filepath)
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        var pos = position

        binding.spin2.setSelection(pos)

        //Toast.makeText(applicationContext, ""+, Toast.LENGTH_SHORT).show()
        if (binding.spin2 != null) {
            //val adapter = ArrayAdapter( this, android.R.layout.simple_spinner_item, muscleGroups )
            // b.adapter = adapter

            binding.spin2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(
                        applicationContext,
                        "" + categoryid[position],
                        Toast.LENGTH_SHORT


                    ).show()

                    finalcid = categoryid[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

            }


            // Toast.makeText(applicationContext, "A1: "+pos, Toast.LENGTH_SHORT).show()

            //var finalcid = binding.spin2.setSelection(pos)
            //Toast.makeText(applicationContext, "A2: ", Toast.LENGTH_SHORT).show()
            //var a = categoryNames[position]
            //categoryid[position] = a
            //Toast.makeText(applicationContext, ""+a, Toast.LENGTH_SHORT).show()

        }


    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }
}