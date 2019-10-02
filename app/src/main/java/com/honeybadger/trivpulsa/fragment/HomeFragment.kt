package com.honeybadger.trivpulsa.fragment


import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator

import com.honeybadger.trivpulsa.R
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.honeybadger.trivpulsa.adapter.CustomPageAdapter
import com.honeybadger.trivpulsa.adapter.SwapAdapter
import com.honeybadger.trivpulsa.model.Model
import kotlinx.android.synthetic.main.fragment_home.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewPager: ViewPager
    private lateinit var tabs: TabLayout

    var swapAdapter:SwapAdapter? = null
    var argbEvaluator: ArgbEvaluator? = null
    var colors: Array<Int>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        viewPager = view.findViewById(R.id.viewpager)
        tabs = view.findViewById(R.id.tabs)

        val fragmentAdapter = CustomPageAdapter(childFragmentManager)
        viewPager.adapter = fragmentAdapter
        tabs.setupWithViewPager(viewPager)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var models = ArrayList<Model>()
        models.add(
            Model(
                R.drawable.brochure,
                "Brochure",
                "Brochure is an informative paper document (often also used for advertising) that can be folded into a template"
            )
        )
        models.add(
            Model(
                R.drawable.sticker,
                "Sticker",
                "Sticker is a type of label: a piece of printed paper, plastic, vinyl, or other material with pressure sensitive adhesive on one side"
            )
        )
        models.add(
            Model(
                R.drawable.poster,
                "Poster",
                "Poster is any piece of printed paper designed to be attached to a wall or vertical surface."
            )
        )
        models.add(
            Model(
                R.drawable.namecard,
                "Namecard",
                "Business cards are cards bearing business information about a company or individual."
            )
        )

        swapAdapter = SwapAdapter(models,context)

        swapViewPager.setAdapter(swapAdapter)
        swapViewPager.setPadding(130, 0, 130, 0)

        val colors_temp = arrayOf(
            resources.getColor(R.color.abc_color_highlight_material),
            resources.getColor(R.color.abc_background_cache_hint_selector_material_light),
            resources.getColor(R.color.abc_hint_foreground_material_dark),
            resources.getColor(R.color.abc_primary_text_disable_only_material_light)
        )

        colors = colors_temp

        swapViewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            @SuppressLint("RestrictedApi")
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

                if (position < swapAdapter!!.getCount() - 1 && position < colors!!.size - 1) {
                    swapViewPager.setBackgroundColor(
                        Color.WHITE
//                        argbEvaluator!!.evaluate(
//                            positionOffset,
//                            colors!![position],
//                            colors!![position + 1]
//                        ) as Int
                    )
                }
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
