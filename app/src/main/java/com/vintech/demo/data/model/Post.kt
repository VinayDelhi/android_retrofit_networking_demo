package com.vintech.demo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class Post(

     @Expose
     @SerializedName("id")
     val id: String,

     @Expose
     @SerializedName("imgUrl")
     val imgUrl: String,

     @Expose
     @SerializedName("imgWidth")
     val imgWidth: Int,

     @Expose
     @SerializedName("imgHeight")
     val imgHeight: Int,

     @Expose
     @SerializedName("createdAt")
     val createdAt: Date,

     @Expose
     @SerializedName("user")
     var user: User,

     @Expose
     @SerializedName("likedBy")
     val likedBy: List<User>
    )
{

    data class User(

        @Expose
        @SerializedName("id")
         val id: String,

        @Expose
        @SerializedName("name")
         val name: String,

        @Expose
        @SerializedName("profilePicUrl")
         val profilePicUrl: String
    )
}
