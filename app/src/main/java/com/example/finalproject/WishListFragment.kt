package com.example.finalproject

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WishListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WishListFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_wish_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myshared = requireActivity().getSharedPreferences("myshared", 0)
        if (myshared.contains("userLoggedIn") == false) {

            val builder = androidx.appcompat.app.AlertDialog.Builder(requireActivity())

            // Sets TITLE for Alert Dialog Box
            // builder.setTitle("ALERT DIALOG BOX")

            // Sets the message you want to display
            builder.setMessage(getString(R.string.msg_login))

            // Creates a positive Button with a Click Listener
            builder.setPositiveButton(getString(R.string.login)) { dialog, which ->

                var intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)

                //to close the app
                // finishAffinity()


            }


            // Creates a Negative Button with a Click Listener
            builder.setNegativeButton(getString(R.string.cancel)) { dialog, which ->

            }


            // Creates a Neutral Button with a Click Listener
            // builder.setNeutralButton("Cancel"){_,_ ->
            //  }
            //  Creates an Alert Dialog and Displays it on the screen
            val dialog: androidx.appcompat.app.AlertDialog = builder.create()
            dialog.show()
        }

    }

}