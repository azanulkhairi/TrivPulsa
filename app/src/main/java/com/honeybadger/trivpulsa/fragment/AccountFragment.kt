package com.honeybadger.trivpulsa.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView

import com.honeybadger.trivpulsa.R
import com.honeybadger.trivpulsa.adapter.CustomListAdapter
import com.honeybadger.trivpulsa.model.AccountMenu
import kotlinx.android.synthetic.main.fragment_account.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AccountFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class AccountFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var list = mutableListOf<AccountMenu>()

        list.add(AccountMenu("Profile",     R.mipmap.ic_launcher  ))
        list.add(AccountMenu("Ubah Kata Sandi",     R.mipmap.ic_launcher_round  ))
        list.add(AccountMenu("Pengaturan",   R.mipmap.ic_launcher  ))
        list.add(AccountMenu("Pusat Bantuan",    R.mipmap.ic_launcher_round  ))
        list.add(AccountMenu("About",    R.mipmap.ic_launcher  ))


        listViewAccount.adapter = context?.let { CustomListAdapter(it, R.layout.listviewimageandtext,list) }

        listViewAccount.setOnItemClickListener{parent, view, position, id ->

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
         * @return A new instance of fragment AccountFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            AccountFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
