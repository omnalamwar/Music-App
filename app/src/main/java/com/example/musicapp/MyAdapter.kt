package com.example.musicapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val arrayList: ArrayList<MyData>)
    :RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(viewType, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = "Title"
        holder.desc.text = "Description"
        holder.time.text = "1:10"
        holder.image.setImageResource(R.drawable.image)
//        Picasso.get().load(arrayList[position].image).into(holder.image);
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var desc: TextView
        var time: TextView
        var image: ShapeableImageView

        init{
            title = itemView.findViewById(R.id.musicTitle1)
            desc = itemView.findViewById(R.id.musicDesc1)
            time = itemView.findViewById(R.id.musicTime1)
            image = itemView.findViewById(R.id.musicImage1)
        }
    }
}