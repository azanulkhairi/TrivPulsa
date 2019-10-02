package com.honeybadger.trivpulsa.util

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import com.honeybadger.trivpulsa.R


// Shared Preference METHODS

class AppPreference(private val context: Context) {

    private val  sharedPreferences: SharedPreferences
    private val editor: SharedPreferences.Editor
    //Setting login status
    var loginStatus: Boolean
        get() = sharedPreferences.getBoolean(R.string.s_pref_login_status.toString(), false)
        set(status) {
            editor.putBoolean(R.string.s_pref_login_status.toString(), status)
            editor.commit()
        }
    // For Name
    var displayName: String?
        get() = sharedPreferences.getString(R.string.s_pref_name.toString(), "Name")
        set(name) {
            editor.putString(R.string.s_pref_name.toString(), name)
            editor.commit()
        }
    //For email
    var displayEmail: String?
        get() = sharedPreferences.getString(R.string.s_pref_email.toString(), "email")
        set(email) {
            editor.putString(R.string.s_pref_email.toString(), email)
            editor.commit()
        }
    //For email
    var creDate: String?
        get() = sharedPreferences.getString(R.string.s_pref_date.toString(), "date")
        set(date) {
            editor.putString(R.string.s_pref_date.toString(), date)
            editor.commit()
        }

    init {
        sharedPreferences = context.getSharedPreferences(R.string.s_pref_file.toString(), Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    // For TOAST Message for response
    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

}