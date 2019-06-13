package com.vintech.demo.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.vintech.demo.data.model.Dummy

/**
 * All properties are var because we will change
 * these in application.
 * */

data class GeneralResponse(

           @Expose
           @SerializedName("statusCode")
           var statusCode: String,

           @Expose
           @SerializedName("status")
           var status: Int,

           @Expose
           @SerializedName("message")
           var message: String

          )