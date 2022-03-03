package com.example.finalproject

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.finalproject.api.ApiInterface
import com.example.finalproject.api.Response
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.specific_character.*
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class SpecicifCharacter: AppCompatActivity() {

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.specific_character)
        var charid :Int = intent.extras?.getInt("id")!!
      fitchSpecificChar(charid)

        progressBar2.visibility = View.VISIBLE

    }


    @DelicateCoroutinesApi
    fun fitchSpecificChar(id : Int) {

        val Basic_Url = "https://gateway.marvel.com/"

        //make a retrofit variable
        val retrofit = Retrofit.Builder()
            //base url
            .baseUrl(Basic_Url)
            //the type of converter
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder().add(
                        KotlinJsonAdapterFactory()
                    ).build()))

            //.client(okHttpClient)
            .build()
            .create(ApiInterface::class.java)
        //launching a new coroutine
        GlobalScope.launch (Dispatchers.IO) {
            val response = retrofit.getDetails(id)
            withContext(Dispatchers.Main){
                if (response.isSuccessful) {
                    progressBar2.visibility = View.INVISIBLE

                    val allData: Response? = response.body() as Response?
                   val image= intent.extras?.get("image")
                    txt_name.text = intent.extras?.getString("name")
                    txt_desc.text = intent.extras?.getString("description")
                    Log.e("image", intent.extras?.getString("image").toString())
                    txt_desc.text = intent.extras?.getString("description")

                    Picasso.get().load(image.toString()).into(image_character)


                }
                }

            }
        }
    }
