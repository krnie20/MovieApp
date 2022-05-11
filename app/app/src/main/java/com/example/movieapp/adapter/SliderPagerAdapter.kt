package com.example.movieapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.item.Slide

class SliderPagerAdapter(private val mContext: Context, private val mList: List<Slide>) :
    PagerAdapter() {
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val slideLayout = inflater.inflate(R.layout.slide_item, null)
        val slideImg = slideLayout.findViewById<ImageView>(R.id.slide_img)
        val slideText = slideLayout.findViewById<TextView>(R.id.slider_title)
        Glide.with(mContext).load(mList[position].imageURL).centerCrop().into(slideImg)
        slideText.text = mList[position].title
        container.addView(slideLayout)
        return slideLayout
    }

    override fun getCount(): Int {
        return mList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}