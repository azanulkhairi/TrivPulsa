package com.honeybadger.trivpulsa.services

import com.honeybadger.trivpulsa.model.LoginPayload
import com.honeybadger.trivpulsa.model.RegisterPayload
import com.honeybadger.trivpulsa.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ServiceApi {

    @POST("/api/auth/signup")
    fun doRegistration(@Body user:RegisterPayload ): Call<User>

    @POST("/api/auth/signin")
    fun doLogin(@Body user:LoginPayload): Call<User>
}