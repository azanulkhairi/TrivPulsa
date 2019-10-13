package com.honeybadger.trivpulsa.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.honeybadger.trivpulsa.R
import com.honeybadger.trivpulsa.model.HistoryModel
import com.honeybadger.trivpulsa.model.NotifModel

class CustomListHistoryAdapter (var mCtx:Context, var resource:Int, var items:List<HistoryModel>)
    :ArrayAdapter<HistoryModel>( mCtx , resource , items ){




    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val layoutInflater :LayoutInflater = LayoutInflater.from(mCtx)

        val view : View = layoutInflater.inflate(resource , null )
        var statusTxt : TextView = view.findViewById(R.id.histroyStatus)
        var nameTxt : TextView = view.findViewById(R.id.historyName)
        var descTxt : TextView = view.findViewById(R.id.historyDesc)
        var dateTxt : TextView = view.findViewById(R.id.histroyDate)
        var numTxt : TextView = view.findViewById(R.id.historyNumber)


        var historyModel : HistoryModel = items[position]

        statusTxt.text = historyModel.status
        nameTxt.text = historyModel.name
        descTxt.text = historyModel.desc
        dateTxt.text = historyModel.date
        numTxt.text = historyModel.number


        return view
    }
}