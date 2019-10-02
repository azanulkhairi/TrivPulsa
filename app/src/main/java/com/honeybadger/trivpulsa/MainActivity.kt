package com.honeybadger.trivpulsa

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.honeybadger.trivpulsa.Activity.LoginActivity
import com.honeybadger.trivpulsa.fragment.AccountFragment
import com.honeybadger.trivpulsa.fragment.HomeFragment
import com.honeybadger.trivpulsa.fragment.NotificationFragment
import com.honeybadger.trivpulsa.fragment.TransactionFragment
import com.honeybadger.trivpulsa.services.ServiceApi
import com.honeybadger.trivpulsa.util.AppPreference
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var appPreference: AppPreference

    private lateinit var serviceApi: ServiceApi

    companion object {
        private const val ID_HOME = 1
        private const val ID_TRANSACTION = 2
        private const val ID_NOTIFICATION = 3
        private const val ID_ACCOUNT = 4
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val bottomNavigation = findViewById<MeowBottomNavigation>(R.id.bottomNavigation)
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_home_black_24dp))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.icons8check52))
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_notifications_black_24dp))
        bottomNavigation.add(MeowBottomNavigation.Model(4, R.drawable.help))

        val home = HomeFragment.newInstance()
        openFragment(home)

        bottomNavigation.setOnShowListener {
            val name = when (it.id) {
                ID_HOME -> "HOME"
                ID_TRANSACTION -> "TRANSACTION"
                ID_NOTIFICATION -> "NOTIFICATION"
                else -> "ACCOUNT"
            }
            // tv_selected.text = "$name page is selected"
        }

        bottomNavigation.setOnClickMenuListener {
            val name = when (it.id) {
                ID_HOME -> {
                    val home =  HomeFragment.newInstance()
                    openFragment(home)

                }
                ID_TRANSACTION -> {
                    val transaction =  TransactionFragment.newInstance()
                    openFragment(transaction)
                }
                ID_NOTIFICATION -> {
                    val notification =  NotificationFragment.newInstance()
                    openFragment(notification)
                }
                else -> {
                    val account =  AccountFragment.newInstance()
                    openFragment(account)
                }
            }
        }


    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
