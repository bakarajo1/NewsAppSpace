package com.example.newsappspace.util.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.newsappspace.R

fun ImageView.setImage(url:String){
    Glide.with(this.context).load(url).placeholder(R.drawable.ic_launcher_background).into(this)

}