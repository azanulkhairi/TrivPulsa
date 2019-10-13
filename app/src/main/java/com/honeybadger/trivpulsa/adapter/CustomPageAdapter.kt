package com.honeybadger.trivpulsa.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.honeybadger.trivpulsa.fragment.homefragment.*

class CustomPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                TopupPulsaFragment()
            }
            1 -> {
                BayarListrikFragment()
            }
            2 -> {
                BayarInternetFragment()
            }
            3 -> {
                BayarTagihanFragment()
            }
            else -> {
                return BayarGameFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 5
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Top up"
            1 -> "Bayar Listrik"
            2 -> "Bayar Internet"
            3 -> "Bayar Tagihan"
            else -> {
                return "Bayar Game"
            }
        }
    }
}