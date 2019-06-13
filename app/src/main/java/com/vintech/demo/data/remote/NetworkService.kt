package com.vintech.demo.data.remote

import com.vintech.demo.data.Networking
import com.vintech.demo.data.remote.request.DummyRequest
import com.vintech.demo.data.remote.response.DummyResponse
import com.vintech.demo.data.remote.response.GeneralResponse
import com.vintech.demo.data.remote.response.PostListResponse
import io.reactivex.Single
import retrofit2.http.*

/**
 * This is used to make network call.
 * Object of this Interfece will be created with
 * the help of networking class. We inject dependency
 * of this obj from out side.
 * */

interface NetworkService {

    /**
     * This method are going to returning response information in Singl<DummyResponse>,
     * because here my concern is into the success result and the error.
     * */

    @POST(Endpoints.DUMMY)
    fun doDummyCall(
        @Body request: DummyRequest,
        @Header(Networking.HEADER_API_KEY) apiKey: String = Networking.API_KEY

    ): Single<DummyResponse>


    @GET(Endpoints.HOME_POST_LIST)
    fun doMyPostCall(

        @Header(Networking.HEADER_API_KEY)apiKey: String = Networking.API_KEY,
        @Header(Networking.HEADER_ACCESS_TOKEN) accessToken: String,
        @Header(Networking.HEADER_USER_ID) userId: String,
        @Query("firstPostId") firstPostId: String?,
        @Query("lastPostId") lastPostId: String?

    ): Single<PostListResponse>

    @DELETE(Endpoints.DELETE_POST)
    fun doDeletePostCall(
        @Header(Networking.HEADER_API_KEY)apiKey: String = Networking.API_KEY,
        @Header(Networking.HEADER_ACCESS_TOKEN) accessToken: String,
        @Header(Networking.HEADER_USER_ID) userId: String,
        @Path("postId") postId: String


    ):Single<GeneralResponse>
}