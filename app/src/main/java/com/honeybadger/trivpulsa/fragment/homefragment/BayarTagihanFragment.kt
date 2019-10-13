package com.honeybadger.trivpulsa.fragment.homefragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.honeybadger.trivpulsa.Activity.BayarGameActivity
import com.honeybadger.trivpulsa.Activity.BayarInternetActivity
import com.honeybadger.trivpulsa.Activity.BayarListrikActivity
import com.honeybadger.trivpulsa.Activity.BayarPulsaActivity

import com.honeybadger.trivpulsa.R
import com.honeybadger.trivpulsa.adapter.LogoAdapter
import com.honeybadger.trivpulsa.model.Logo
import kotlinx.android.synthetic.main.fragment_bayar_tagihan.*
import kotlinx.android.synthetic.main.fragment_topup_pulsa.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BayarTagihanFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BayarTagihanFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BayarTagihanFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_bayar_tagihan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var logoList= ArrayList<Logo>()

        logoList?.add(Logo("PLN", R.drawable.icons8check52))
        logoList?.add(Logo("TELKOMVISION", R.drawable.icons8beam))
        logoList?.add(Logo("YES TV", R.drawable.icons8contactdetail))
        logoList?.add(Logo("AORA TV", R.drawable.icons8electricity52))
        logoList?.add(Logo("INDOVISION", R.drawable.icons8linux48))
        logoList?.add(Logo("TELKOM PSTN", R.drawable.icons8mobilephone52))
        logoList?.add(Logo("TELKOM SPEEDY", R.drawable.icons8beam))
        logoList?.add(Logo("NEXMEDIA", R.drawable.icons8check52))
        logoList?.add(Logo("Telkomsel Halo", R.drawable.icons8beam))
        logoList?.add(Logo("Flexy Classy", R.drawable.icons8contactdetail))
        logoList?.add(Logo("XL Pasca Bayar", R.drawable.icons8electricity52))
        logoList?.add(Logo("Indosat Matrix", R.drawable.icons8linux48))
        logoList?.add(Logo("TELKOM PSTN", R.drawable.icons8mobilephone52))
        logoList?.add(Logo("Esia Pasca Bayar", R.drawable.icons8beam))
        logoList?.add(Logo("Smartfren Pasca Bayar", R.drawable.icons8contactdetail))
        logoList?.add(Logo("BIG TV", R.drawable.icons8electricity52))
        logoList?.add(Logo("INOVATE", R.drawable.icons8linux48))
        logoList?.add(Logo("PGN", R.drawable.icons8mobilephone52))

        adapter = LogoAdapter(logoList,context)

        gridviewBayarTagihan.adapter = adapter

        gridviewBayarTagihan.setOnItemClickListener { parent, view, position, id ->
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
         * @return A new instance of fragment BayarTagihanFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            BayarTagihanFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
