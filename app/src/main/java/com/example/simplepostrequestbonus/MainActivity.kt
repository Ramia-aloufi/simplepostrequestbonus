package com.example.simplepostrequestbonus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewfromapibonus.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var et:EditText
    lateinit var btn:Button
    lateinit var rr :Names.NamesItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et = findViewById(R.id.editTextTextPersonName)
        btn = findViewById(R.id.button)
        rr = Names.NamesItem()


        btn.setOnClickListener {
            PostName()
        }

    }
    fun PostName(){
        var tt = et.text.toString()
        rr.name = tt
        val apiInterface = Constants.apiInterface
       apiInterface!!.added(rr)?.enqueue(object : Callback<Names.NamesItem>{
           override fun onResponse(call: Call<Names.NamesItem>, response: Response<Names.NamesItem>) {
               Log.d("rr", response.code().toString())
               Log.d("rr","$rr")

               Toast.makeText(this@MainActivity,"Addedd",Toast.LENGTH_SHORT).show()
           }

           override fun onFailure(call: Call<Names.NamesItem>, t: Throwable) {
               Toast.makeText(this@MainActivity,"Failure",Toast.LENGTH_SHORT).show()

           }

       } )
    }
}