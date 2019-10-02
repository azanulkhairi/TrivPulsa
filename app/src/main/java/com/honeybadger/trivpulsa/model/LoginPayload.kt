package com.honeybadger.trivpulsa.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class LoginPayload(
    @SerializedName("usernameOrEmail")
    var  usernameOrEmail:String? =null,

    @SerializedName("password")
    var  password:String?=null

):Parcelable
