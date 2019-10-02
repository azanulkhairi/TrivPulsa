package com.honeybadger.trivpulsa.services

interface ServiceInterface {

    fun register()
    fun login(name:String, email:String)
    fun logout()
}