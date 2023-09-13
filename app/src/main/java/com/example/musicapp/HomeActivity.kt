package com.example.musicapp

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = findViewById(R.id.recyclerView)

        Log.d(TAG, "Fetching data from api")
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyInterface::class.java)

        var retrofitData = retrofitBuilder.getMyData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val resp = response.body()
                val productList = resp?.products!!
                recyclerView.adapter = MyAdapter(this@HomeActivity, productList)
                recyclerView.layoutManager = LinearLayoutManager(this@HomeActivity)
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Toast.makeText(this@HomeActivity, "Not able to fetch data", Toast.LENGTH_SHORT).show()
            }
        })
    }
}