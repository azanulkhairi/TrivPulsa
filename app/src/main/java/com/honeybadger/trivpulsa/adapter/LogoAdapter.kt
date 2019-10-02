package com.honeybadger.trivpulsa.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.honeybadger.trivpulsa.R
import com.honeybadger.trivpulsa.model.Logo
import kotlinx.android.synthetic.main.gridview_pulsa.view.*

class LogoAdapter : BaseAdapter {

    var logoList = ArrayList<Logo>()
    var context: Context? = null

    constructor(logoList: ArrayList<Logo>, context: Context?) : super() {
        this.logoList = logoList
        this.context = context
    }

    override fun getCount(): Int {
        return logoList.size
    }

    override fun getItem(position: Int): Any {
        return logoList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val food = this.logoList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var logoView = inflator.inflate(R.layout.gridview_pulsa, null)
        logoView.imgLogo.setImageResource(food.image!!)
        logoView.textViewLogo.text = food.name!!

        return logoView
    }
}