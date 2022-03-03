package com.example.finalproject

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat.recreate
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_more.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
lateinit var myshared : SharedPreferences

/**
 * A simple [Fragment] subclass.
 * Use the [MoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoreFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_more, container, false)
    }

    @SuppressLint("CommitPrefEdits")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myshared = requireActivity().getSharedPreferences("myshared", 0)
        if (myshared.contains("userLoggedIn") == false) {

            val builder = AlertDialog.Builder(requireActivity())
            builder.setCancelable(false)
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
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        txt_prof.setOnClickListener {
            var intent = Intent(activity, Profile::class.java)
            startActivity(intent)
        }
        txt_language.setOnClickListener {

            changeLanguage()

        }
        txt_logout.setOnClickListener {

            val builder = AlertDialog.Builder(requireActivity())

            // Sets TITLE for Alert Dialog Box
            builder.setTitle(R.string.log_out)

            // Sets the message you want to display
            builder.setMessage(getString(R.string.msg_logout))

            // Creates a positive Button with a Click Listener
            builder.setPositiveButton(getString(R.string.log_out)) { dialog, which ->

                var intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)

                //to close the app
                // finishAffinity()
                myshared = requireActivity().getSharedPreferences("myshared", 0)
                var editor : SharedPreferences.Editor = myshared.edit()
                editor.clear().apply()

            }

            // Creates a Negative Button with a Click Listener
            builder.setNegativeButton(getString(R.string.cancel)) { dialog, which ->

            }


            // Creates a Neutral Button with a Click Listener
            // builder.setNeutralButton("Cancel"){_,_ ->
            //  }
            //  Creates an Alert Dialog and Displays it on the screen
            val dialog: AlertDialog = builder.create()
            dialog.show()


        }


    }

    private fun changeLanguage() {
        var listItem = arrayOf("عربي","English")
        val mBuilder = AlertDialog.Builder(requireActivity())
        mBuilder.setTitle("Choose Language")
        mBuilder.setSingleChoiceItems(listItem,-1){dialog ,which->
            if (which == 0){
                setLocate("ar")
                requireActivity().recreate()
            }
            else if (which == 1){
                setLocate("Default Value")
                requireActivity().recreate()
            }
            dialog.dismiss()
        }
        val mDialog = mBuilder.create()
        mBuilder.show()
    }

    @SuppressLint("CommitPrefEdits")
    private fun setLocate(Lang: String) {
        val locale = Locale(Lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        requireActivity().baseContext.resources.updateConfiguration(config ,requireActivity(). baseContext.resources.displayMetrics)

        val editor = requireActivity().getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang",Lang)
        editor.apply()
    }

    private fun loadLocate(){
        val sharedPreferences = requireActivity().getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang","")
        if (language != null) {
            setLocate(language)
        }
    }


    override fun onResume() {
        super.onResume()
        myshared = requireActivity().getSharedPreferences("myshared", 0)
        if (myshared.contains("userLoggedIn") == false) {

            val builder = androidx.appcompat.app.AlertDialog.Builder(requireActivity())
            builder.setCancelable(false)

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