package com.honeybadger.trivpulsa.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.honeybadger.trivpulsa.R
import com.honeybadger.trivpulsa.model.AccountMenu

class CustomListAdapter (var mCtx:Context , var resource:Int,var items:List<AccountMenu>)
    :ArrayAdapter<AccountMenu>( mCtx , resource , items ){




    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater :LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = layoutInflater.inflate(resource , null )
        val imageView :ImageView = view.findViewById(R.id.iconIv)
        var textView : TextView = view.findViewById(R.id.titleTv)


        var accountMenu : AccountMenu = items[position]

        imageView.setImageDrawable(mCtx.resources.getDrawable(accountMenu.photo))
        textView.text = accountMenu.title


        return view
    }
}