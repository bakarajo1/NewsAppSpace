package com.example.newsappspace.adapters.newsAdapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class DiffUtil<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = oldItem === newItem

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean = oldItem == newItem
}