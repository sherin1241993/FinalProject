package com.example.finalproject

import android.app.Service
import android.content.Intent
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SplashScreen : AppCompatActivity() {


    // variable for splash screen time
    private val splash: Long = 4000
    lateinit var handler: Handler

    // variables for internet connection
    var context = this
    var connectivity: ConnectivityManager? = null
    var info: NetworkInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //Picasso.get().load(R.drawable.jupiter).fit().into(sp_screen)

        //splash screen
        handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            // close this activity
            finish()
        }, splash)


        //internet connection

        connectivity = context.getSystemService(Service.CONNECTIVITY_SERVICE)
                as ConnectivityManager

        if (connectivity != null)
        {
            info = connectivity!!.activeNetworkInfo

            if (info != null) {
                if (info!!.state == NetworkInfo.State.CONNECTED) {
                    Toast.makeText(context, "CONNECTED TO INTERNET", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(context, "PLEASE CHECK INTERNET CONNECTION", Toast.LENGTH_LONG).show()
            }


        }



    }

}
