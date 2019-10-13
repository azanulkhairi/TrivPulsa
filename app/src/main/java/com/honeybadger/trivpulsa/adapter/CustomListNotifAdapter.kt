package com.honeybadger.trivpulsa.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.honeybadger.trivpulsa.R
import com.honeybadger.trivpulsa.model.NotifModel

class CustomListNotifAdapter (var mCtx:Context, var resource:Int, var items:List<NotifModel>)
    :ArrayAdapter<NotifModel>( mCtx , resource , items ){




    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater :LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = layoutInflater.inflate(resource , null )
        val imageView :ImageView = view.findViewById(R.id.iconNotif)
        var headerTxt : TextView = view.findViewById(R.id.headerNotif)
        var nameTxt : TextView = view.findViewById(R.id.notifName)
        var descTxt : TextView = view.findViewById(R.id.notifDesc)
        var dateTxt : TextView = view.findViewById(R.id.notifDate)


        var notifModel : NotifModel = items[position]

        imageView.setImageDrawable(mCtx.resources.getDrawable(notifModel.photo))
        headerTxt.text = notifModel.title
        nameTxt.text = notifModel.name
        descTxt.text = notifModel.desc
        dateTxt.text = notifModel.date


        return view
    }
}