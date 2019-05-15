package com.example.android.kotlinyoutuope

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // recyclerView_main.setBackgroundColor(Color.BLUE)
        recyclerView_main.layoutManager=LinearLayoutManager(this)
        fetchJson()

    }


    fun fetchJson(){
        println("Attempt to fech json")
        val url="https://api.letsbuildthatapp.com/youtube/home_feed"
        val request= Request.Builder().url(url).build()
        val client= OkHttpClient()
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val boby= response.body()?.string()
                val gson= GsonBuilder().create()
                val homeFeed= gson.fromJson(boby,HomeFeed::class.java)
               runOnUiThread{
                   recyclerView_main.adapter=MainAdapter(homeFeed)
               }
                println(boby)
              
            }

            override fun onFailure(call: Call, e: IOException) {
                println("failed in execute request")
            }
        })
    }
    }





