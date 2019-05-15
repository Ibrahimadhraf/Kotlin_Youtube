package com.example.android.kotlinyoutuope

import android.content.Intent
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_course_details.view.*
import kotlinx.android.synthetic.main.courselaesson_row.view.*

class CustomerDetailsAdapter(val courseLesson: Array<CourseLesson>): RecyclerView.Adapter<CourseDetailsLessonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseDetailsLessonViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val customeView=layoutInflater.inflate(R.layout.courselaesson_row,parent,false)
        return CourseDetailsLessonViewHolder(customeView)

    }

    override fun getItemCount(): Int {
       return courseLesson.size
    }

    override fun onBindViewHolder(holder: CourseDetailsLessonViewHolder, position: Int) {
        val courseLesson =courseLesson.get(position)
        holder.customView.textView2.text=courseLesson.name
        holder.customView.textView4.text=courseLesson.duration
        Picasso.get().load(courseLesson.imageUrl).into(holder.customView.imageView2)
        holder.courseLesson=courseLesson
    }



}
class CourseDetailsLessonViewHolder(  val customView: View,var courseLesson: CourseLesson?=null)
    : RecyclerView.ViewHolder(customView){
    companion object{
        val COURSE_LESSON_LINK_KEY="COURSE_LESSON_LINK"
    }
    init {
        customView.setOnClickListener {
            val intent=Intent(customView.context,CourseLessonActivity::class.java)
            intent.putExtra(COURSE_LESSON_LINK_KEY,courseLesson?.link)
           customView.context.startActivity(intent)
        }
    }

}