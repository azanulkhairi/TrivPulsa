package com.honeybadger.trivpulsa.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class RegisterPayload (
    @SerializedName("name")
    var  name:String? =null,

    @SerializedName("username")
    var  username:String? =null,

    @SerializedName("email")
    var  email:String? =null,

    @SerializedName("password")
    var  password:String?=null
): Parcelable