package com.example.movieapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.interfaces.ButtonListener
import com.example.movieapp.R
import com.example.movieapp.model.Slide
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SliderPagerAdapter(
    var context: Context,
    var mData: List<Slide>,
    var btListener: ButtonListener
) : RecyclerView.Adapter<SliderPagerAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val TvTitle: TextView = itemView.findViewById(R.id.slider_title)
        val ImgMovie: ImageView = itemView.findViewById(R.id.slide_img)
        val bt : FloatingActionButton = itemView.findViewById(R.id.floatingActionButton)

        init {
            bt.setOnClickListener {
                btListener.onSliderClick(mData[adapterPosition], bt)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.slide_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.TvTitle.text = mData.get(position).title
        Glide.with(context).load(mData.get(position).imageURL).into(holder.ImgMovie)
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}