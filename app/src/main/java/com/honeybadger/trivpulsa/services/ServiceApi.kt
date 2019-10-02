package com.honeybadger.trivpulsa.services

import com.honeybadger.trivpulsa.model.LoginPayload
import com.honeybadger.trivpulsa.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ServiceApi {

    @POST("/api/auth/signup")
    fun doRegistration(@Query("name") name:String,@Query("email") email:String, @Query("username") username:String, @Query("password")  password:String): Call<User>

    @POST("/api/auth/signin")
    fun doLogin(@Body user:LoginPayload): Call<User>
}