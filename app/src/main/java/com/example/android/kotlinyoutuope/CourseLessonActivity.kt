package com.example.android.kotlinyoutuope

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_course_lesson.*
import android.webkit.WebSettings



class CourseLessonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_lesson)
        val courseLink=intent.getStringExtra(CourseDetailsLessonViewHolder.COURSE_LESSON_LINK_KEY)
        val webSettings = webView_course_lesson.getSettings()
        webSettings.setJavaScriptEnabled(true)

        webView_course_lesson.loadUrl(courseLink)
    }
}
