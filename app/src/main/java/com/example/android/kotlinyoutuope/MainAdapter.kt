package com.example.android.kotlinyoutuope

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.vedio_row.view.*


class MainAdapter(val homeFeed: HomeFeed) : RecyclerView.Adapter<CustomeViewHolder>()

{
    val homeData= listOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomeViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val callFromRow=layoutInflater.inflate(R.layout.vedio_row,parent,false)
        return CustomeViewHolder(callFromRow)
    }

    override fun onBindViewHolder(holder: CustomeViewHolder,position: Int) {
      val viedio=homeFeed.videos.get(position)
   holder.view.vedio_title.text=viedio.name
        holder.view.channelname.text=viedio.channel.name

        Picasso.get().load(viedio.imageUrl).into(holder.view.imageView)
        Picasso.get().load(viedio.channel.profileImageUrl).into(holder.view.imageView_personal)
        holder.vidios=viedio

    }


    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }



}


class CustomeViewHolder(val view: View, var vidios: Vidios?=null) :RecyclerView.ViewHolder(view){
    companion object{
        val VIDIEO_TITLE_KEY="VIDIEOTITLE"
         val VIDIEO_ID_KEY="vedioId"
    }
    init {
            view.setOnClickListener {
                println("TEST")
                val intent=Intent(view.context,CourseDetailsActivity::class.java)
                intent.putExtra(VIDIEO_TITLE_KEY,vidios?.name)
                intent.putExtra(VIDIEO_ID_KEY,vidios?.id)
                view.context.startActivity(intent)
            }
    }

}