package com.vintech.demo.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @Expose: this annotation help the GSON which field
 * need to be parse. If we don't want to some fields not parse
 * don't write @Expose on that fields.
 *
 * @SerializedName: It will help when run proguard.
 *
 * */

data class Dummy(

         @Expose
         @SerializedName("name")
         private val name: String,

         @Expose
         @SerializedName("imgUrl")
         private val imgUrl: String

       )
{
}