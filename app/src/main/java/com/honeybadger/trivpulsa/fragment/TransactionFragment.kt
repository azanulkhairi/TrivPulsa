package com.honeybadger.trivpulsa.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.honeybadger.trivpulsa.R
import com.honeybadger.trivpulsa.adapter.CustomListHistoryAdapter
import com.honeybadger.trivpulsa.model.HistoryModel
import kotlinx.android.synthetic.main.fragment_transaction.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [TransactionFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [TransactionFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class TransactionFragment : Fragment() {
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var list = mutableListOf<HistoryModel>()

        list.add(HistoryModel("Transaksi Pulsa",       "jsajgasj kjagdjagdjas gjagsdjasd jadgajks", "34234234","2 Oktober 2019","Sukses"))
        list.add(HistoryModel("Transaksi Listrik",       "jsajgasj kjagdjagdjas gjagsdjasd jadgajks", "34234234","2 Oktober 2019","Sukses"))
        list.add(HistoryModel("Transaksi Pulsa",   "jsajgasj kjagdjagdjas gjagsdjasd jadgajks", "34234234","2 Oktober 2019" ,"Sukses"))
        list.add(HistoryModel("Transaksi Pulsa",    "jsajgasj kjagdjagdjas gjagsdjasd jadgajks", "34234234","2 Oktober 2019","Sukses"  ))
        list.add(HistoryModel("Transaksi Tagihan PLN",      "jsajgasj kjagdjagdjas gjagsdjasd jadgajks", "34234234","2 Oktober 2019","Sukses"))


        listViewHistory.adapter = context?.let { CustomListHistoryAdapter(it, R.layout.listviewhistory,list) }

        listViewHistory.setOnItemClickListener{parent, view, position, id ->

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transaction, container, false)
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TransactionFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            TransactionFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}
