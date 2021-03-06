package com.honeybadger.trivpulsa.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.honeybadger.trivpulsa.R
import com.honeybadger.trivpulsa.adapter.CustomListAdapter
import com.honeybadger.trivpulsa.adapter.CustomListNotifAdapter
import com.honeybadger.trivpulsa.model.AccountMenu
import com.honeybadger.trivpulsa.model.NotifModel
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_notification.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [NotificationFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [NotificationFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class NotificationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var list = mutableListOf<NotifModel>()

        list.add(NotifModel("Transaksi Pulsa",     R.mipmap.ic_launcher , "Top Up", "jsajgasj kjagdjagdjas gjagsdjasd jadgajks", "2 Oktober 2019"))
        list.add(NotifModel("Transaksi Listrik",     R.mipmap.ic_launcher_round , "Bayar Tagihan" ,"jsajgasj kjagdjagdjas gjagsdjasd jadgajks", "2 Oktober 2019"))
        list.add(NotifModel("Transaksi Pulsa",   R.mipmap.ic_launcher ,"Top Up","jsajgasj kjagdjagdjas gjagsdjasd jadgajks", "2 Oktober 2019" ))
        list.add(NotifModel("Transaksi Pulsa",    R.mipmap.ic_launcher_round,"Top Up","jsajgasj kjagdjagdjas gjagsdjasd jadgajks", "2 Oktober 2019"  ))
        list.add(NotifModel("Transaksi Tagihan PLN",    R.mipmap.ic_launcher , "Bayar Tagihan", "jsajgasj kjagdjagdjas gjagsdjasd jadgajks", "2 Oktober 2019"))


        listViewNotif.adapter = context?.let { CustomListNotifAdapter(it, R.layout.listviewnotifikasi,list) }

        listViewNotif.setOnItemClickListener{parent, view, position, id ->

            if (position==0){

            }
            if (position==1){

            }
            if (position==2){

            }
            if (position==3){

            }
            if (position==4){

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
         * @return A new instance of fragment NotificationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            NotificationFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
