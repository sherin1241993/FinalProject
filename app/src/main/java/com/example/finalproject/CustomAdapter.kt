package com.example.finalproject

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.api.Response
import com.example.finalproject.api.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_row_posts.view.*


class CustomAdapter(val userList : List<Result>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val v =
                LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_posts, parent, false)
            return ViewHolder(v)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val dataPosts = userList!![position]
            holder.bind(dataPosts)
        }

        override fun getItemCount(): Int {
            return userList.size
        }

        class ViewHolder(itemView: View, var my_data: Result? = null) :
            RecyclerView.ViewHolder(itemView) {
            // catch the element
            @SuppressLint("SetTextI18n")
            fun bind(mydata: Result){
                val avatarName = itemView.tx_title as TextView
                val avatarImage = itemView.avatar_img as ImageView


                avatarName.text = mydata.name
                Picasso.get().load(mydata.thumbnail.path+"."+mydata.thumbnail.extension).into(avatarImage)


                itemView.setOnClickListener {

                    var intent = Intent(itemView.context, SpecicifCharacter::class.java)
                    intent.putExtra("id",mydata.id)
                    intent.putExtra("image",mydata.thumbnail.path+"."+mydata.thumbnail.extension)
                    intent.putExtra("name",mydata.name)
                    intent.putExtra("description",mydata.description)

                    itemView.context.startActivity(intent)
                }


            }

        }
    }