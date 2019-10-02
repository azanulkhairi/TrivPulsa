package com.honeybadger.trivpulsa.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.honeybadger.trivpulsa.R
import kotlinx.android.synthetic.main.activity_bayar_pulsa.*

class BayarPulsaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bayar_pulsa)

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOf("100000", "250000", "50000"))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        nominalPulsaSpinner.adapter = adapter

        nominalPulsaSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                // either one will work as well
                // val item = parent.getItemAtPosition(position) as String
                val item = adapter.getItem(position)
            }
        }
    }
}
