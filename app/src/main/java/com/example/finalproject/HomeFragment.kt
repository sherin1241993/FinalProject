package com.example.finalproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.api.ApiInterface
import com.example.finalproject.api.Response
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    @DelicateCoroutinesApi
    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_posts.layoutManager = LinearLayoutManager(this.context, LinearLayout.VERTICAL, false)
        fitchAllPosts()

    }



    @DelicateCoroutinesApi
    fun fitchAllPosts() {

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
            val response = retrofit.getData()
            withContext(Dispatchers.Main){
                if (response.isSuccessful) {

                    val allData: Response? =
                        response.body() as Response?
                    recycler_posts.adapter = allData?.let { CustomAdapter(it.data.results) }
                }

            }
        }
    }
}