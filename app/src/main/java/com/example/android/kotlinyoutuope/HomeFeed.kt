package com.example.android.kotlinyoutuope

/*
"id":2,
         "name":"Intermediate Training Core Data",
         "link":"https://www.letsbuildthatapp.com/course/intermediate-training-core-data",
         "imageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/0736fecb-5b88-483b-a83d-ca2a5a6d93f9",
         "numberOfViews":5000,
         "channel":{
            "name":"Lets Build That App",
            "profileImageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/dda5bc77-327f-4944-8f51-ba4f3651ffdf",
            "numberOfSubscribers":100000
 */
class HomeFeed(val videos :List<Vidios>)
class Vidios(val id:Int,val name:String,val link :String,val imageUrl:String,
             val numberOfViews:Int, val channel:Channel)
class Channel( val name:String,val profileImageUrl:String, val numberOfSubscribers:Int)
/*
 "name":"Firebase SDK and User Registration",
      "duration":"17:34",
      "number":3,
      "imageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/ef96b470-785c-4fed-bad7-d2cc972932fd_thumbnail",
      "link":"https://www.letsbuildthatapp.com/course_video?id=1042"
 */
class CourseLesson(val name: String,val duration:String,val number:Int,val imageUrl:String,val link:String)