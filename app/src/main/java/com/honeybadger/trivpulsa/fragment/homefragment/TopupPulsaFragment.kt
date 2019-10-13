package com.honeybadger.trivpulsa.fragment.homefragment

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.honeybadger.trivpulsa.R
import com.honeybadger.trivpulsa.adapter.LogoAdapter
import com.honeybadger.trivpulsa.adapter.SwapAdapter
import com.honeybadger.trivpulsa.model.Logo
import com.honeybadger.trivpulsa.model.Model
import kotlinx.android.synthetic.main.fragment_topup_pulsa.*
import androidx.viewpager.widget.ViewPager
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator
import com.honeybadger.trivpulsa.Activity.BayarGameActivity
import com.honeybadger.trivpulsa.Activity.BayarInternetActivity
import com.honeybadger.trivpulsa.Activity.BayarListrikActivity
import com.honeybadger.trivpulsa.Activity.BayarPulsaActivity
import com.honeybadger.trivpulsa.MainActivity


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TopupPulsaFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TopupPulsaFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TopupPulsaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var adapter:LogoAdapter? = null



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
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_topup_pulsa, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var logoList= ArrayList<Logo>()

        logoList?.add(Logo("ISI PULSA", R.drawable.icons8check52))
        logoList?.add(Logo("ISI KUOTA", R.drawable.icons8beam))
        logoList?.add(Logo("FISIK KUOTA", R.drawable.icons8contactdetail))
        logoList?.add(Logo("ACT THREE", R.drawable.icons8electricity52))
        logoList?.add(Logo("PAKET SMS", R.drawable.icons8linux48))
        logoList?.add(Logo("PAKET NELPON", R.drawable.icons8mobilephone52))
        logoList?.add(Logo("TELKOM SPEEDY", R.drawable.icons8mouserightclick64))
        logoList?.add(Logo("TOP UP OVO", R.drawable.icons8beam))
        logoList?.add(Logo("TOP UP GOPAY", R.drawable.icons8contactdetail))
        logoList?.add(Logo("TOP UP LINK AJA", R.drawable.icons8electricity52))
        logoList?.add(Logo("TOP UP DANA", R.drawable.icons8linux48))

        adapter = LogoAdapter(logoList,context)

        gridviewTopupPulsa.adapter = adapter
        
        gridviewTopupPulsa.setOnItemClickListener { parent, view, position, id ->
            val pos = when (position){
                0 ->{
                    val intent = Intent(this.context, BayarGameActivity::class.java)
                    startActivity(intent)
                }
                1 ->{
                    val intent = Intent(this.context, BayarInternetActivity::class.java)
                    startActivity(intent)
                }
                2 ->{
                    val intent = Intent(this.context, BayarListrikActivity::class.java)
                    startActivity(intent)
                }
                3 ->{
                    val intent = Intent(this.context, BayarPulsaActivity::class.java)
                    startActivity(intent)
                }
                4 ->{
                    val intent = Intent(this.context, BayarInternetActivity::class.java)
                    startActivity(intent)
                }
                else ->{
                    val intent = Intent(this.context, BayarInternetActivity::class.java)
                    startActivity(intent)
                }
            }
        }



    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TopupPulsaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            TopupPulsaFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
