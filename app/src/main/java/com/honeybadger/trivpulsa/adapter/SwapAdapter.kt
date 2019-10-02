package com.honeybadger.trivpulsa.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.honeybadger.trivpulsa.Activity.LoginActivity
import com.honeybadger.trivpulsa.R
import com.honeybadger.trivpulsa.model.Model

class SwapAdapter(private val models: List<Model>, private val context: Context?) : PagerAdapter() {
    private var layoutInflater: LayoutInflater? = null

    override fun getCount(): Int {
        return models.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater!!.inflate(R.layout.swapitem, container, false)

        val imageView: ImageView
        val title: TextView
        val desc: TextView

        imageView = view.findViewById(R.id.image)
        title = view.findViewById(R.id.title)
        desc = view.findViewById(R.id.desc)

        imageView.setImageResource(models[position].image)
        title.text = models[position].title
        desc.text = models[position].desc

//        view.setOnClickListener {
//            val intent = Intent(context, LoginActivity::class.java)
//            intent.putExtra("param", models[position].title)
//            context.startActivity(intent)
//            // finish();
//        }

        container.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
