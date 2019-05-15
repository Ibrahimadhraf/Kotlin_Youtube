package com.example.android.kotlinyoutuope

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.view.SupportActionModeWrapper
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_course_details.*
import okhttp3.*
import java.io.IOException

class CourseDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_details)
      courseDetails.layoutManager=LinearLayoutManager(this)
       val navBareTitle= intent.getStringExtra(CustomeViewHolder.VIDIEO_TITLE_KEY)

       supportActionBar?.title=navBareTitle
       fetchJson()
    }
    private fun fetchJson(){
        val vedio_id=intent.getIntExtra(CustomeViewHolder.VIDIEO_ID_KEY,-1)
        val courseDetailsUrl="https://api.letsbuildthatapp.com/youtube/course_detail?id="+vedio_id
        val client=OkHttpClient()
        val request=Request.Builder().url(courseDetailsUrl).build()
        client.newCall(request).enqueue(object :Callback{
            override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
              val body= response.body()?.string()
                val gson= GsonBuilder().create()
                val courseLesson= gson.fromJson(body,Array<CourseLesson>::class.java)
                runOnUiThread {
                    courseDetails.adapter = CustomerDetailsAdapter(courseLesson)
                }
                println(body)
            }
        })
    }


}
