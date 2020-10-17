package com.honeybadger.trivpulsa.Activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.view.View
import com.honeybadger.trivpulsa.BuildConfig
import com.honeybadger.trivpulsa.MainActivity
import com.honeybadger.trivpulsa.R
import com.honeybadger.trivpulsa.model.LoginPayload
import com.honeybadger.trivpulsa.model.RegisterPayload
import com.honeybadger.trivpulsa.model.User
import com.honeybadger.trivpulsa.services.RetrofitClient
import com.honeybadger.trivpulsa.services.ServiceApi
import com.honeybadger.trivpulsa.util.AppPreference
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var serviceApi: ServiceApi

    private lateinit var appPreference: AppPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        serviceApi = RetrofitClient.getApiClient(BuildConfig.BASE_URL).create(ServiceApi::class.java)

        appPreference = AppPreference(this);

        buttonRegister.setOnClickListener {
            attemptRegister()
        }
    }


    fun RegisterUser() {
            var name = txUsername.text.toString()
            var userName  = txFullname.text.toString()
            var email = emailRegister.text.toString()
            var password = passwordRegister.text.toString()
            var retypePassword = RetyppasswordRegister.text.toString()
            var userRegister = RegisterPayload(name, userName,email,password)
            var userCall : Call<User> = serviceApi.doRegistration(userRegister);
            Log.d("test",userCall.toString())
            userCall.enqueue(object : Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {
                    appPreference.showToast("Error. Login Failed");
                    txUsername.setText("");
                    txFullname.setText("");
                    emailRegister.setText("");
                    passwordRegister.setText("");
                    RetyppasswordRegister.setText("");
                    Log.d("test",t.message)
                }

                @Override
                override fun  onResponse (call: Call<User>, response: Response<User>) {
                    Log.d("test", response.code().toString())
                    if (response.code()?.toString().equals("200")){
                        Log.d("test","masukkk")
                        appPreference.loginStatus = true// set login status in sharedPreference
//                        serviceInterface.login(
//                            response.body()?.name!!,
//                            response.body()?.email!!
//
//                        )
                        Log.d("test",response.message())

                        showProgress(false)

                        val intent = Intent(applicationContext, LoginActivity::class.java)
                        startActivity(intent)
                    } else {
                        appPreference.showToast("Error. Login Failed");
                        txUsername.setText("");
                        txFullname.setText("");
                        emailRegister.setText("");
                        passwordRegister.setText("");
                        RetyppasswordRegister.setText("");
                    }
                }
            });
        }



    private fun attemptRegister() {


        // Reset errors.
        txUsername.error = null
        txFullname.error = null
        emailRegister.error = null
        passwordRegister.error = null
        RetyppasswordRegister.error = null

        // Store values at the time of the login attempt.
        var name = txUsername.text.toString()
        var userName  = txFullname.text.toString()
        var email = emailRegister.text.toString()
        var password = passwordRegister.text.toString()
        var retypePassword = RetyppasswordRegister.text.toString()

        var cancel = false
        var focusView: View? = null

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordRegister.error = getString(R.string.error_invalid_password)
            focusView = passwordRegister
            cancel = true
        }

        if (retypePassword != password) {
            passwordRegister.error = getString(R.string.error_notmatch_password)
            focusView = passwordRegister
            cancel = true
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            emailRegister.error = getString(R.string.error_field_required)
            focusView = emailRegister
            cancel = true
        } else if (!isEmailValid(email)) {
            emailRegister.error = getString(R.string.error_invalid_email)
            focusView = emailRegister
            cancel = true
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView?.requestFocus()
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true)
            RegisterUser()
        }
    }

    private fun isEmailValid(email: String): Boolean {
        //TODO: Replace this with your own logic
        return email.contains("@")
    }

    private fun isPasswordValid(password: String): Boolean {
        //TODO: Replace this with your own logic
        return password.length > 4
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private fun showProgress(show: Boolean) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            val shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime).toLong()

            register_form.visibility = if (show) View.GONE else View.VISIBLE
            register_form.animate()
                .setDuration(shortAnimTime)
                .alpha((if (show) 0 else 1).toFloat())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        login_form.visibility = if (show) View.GONE else View.VISIBLE
                    }
                })

            register_progress.visibility = if (show) View.VISIBLE else View.GONE
            register_progress.animate()
                .setDuration(shortAnimTime)
                .alpha((if (show) 1 else 0).toFloat())
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        register_progress.visibility = if (show) View.VISIBLE else View.GONE
                    }
                })
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            register_progress.visibility = if (show) View.VISIBLE else View.GONE
            register_form.visibility = if (show) View.GONE else View.VISIBLE
        }
    }
}
