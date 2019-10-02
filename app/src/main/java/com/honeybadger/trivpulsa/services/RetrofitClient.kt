package com.honeybadger.trivpulsa.services

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object{
        fun getApiClient(baseUrl:String):Retrofit {
            var retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            Log.e("RetrofitClient", baseUrl)

            return retrofit
        }
    }


}