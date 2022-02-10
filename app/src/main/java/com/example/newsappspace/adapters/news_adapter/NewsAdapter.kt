package com.example.newsappspace.adapters.news_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsappspace.R
import com.example.newsappspace.adapters.OnClickListener
import com.example.newsappspace.databinding.NewsItemLayoutBinding
import com.example.newsappspace.model.ArticleX


class NewsAdapter(private val onClickListener: OnClickListener) :

    ListAdapter<ArticleX, NewsAdapter.ViewHolder>(DiffUtil<ArticleX>()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            NewsItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position), onClickListener)
    }

    class ViewHolder(private val binding: NewsItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(article: ArticleX, onClickListener: OnClickListener) {
            with(binding) {
                titleTextView.text = article.title
                providerTextView.text = article.source?.name
                dateTextView.text = article.publishedAt
                Glide.with(newsImageView).load(article.urlToImage).placeholder(R.drawable.ic_launcher_background).into(newsImageView)

                singleLay.setOnClickListener {
                    onClickListener.onItemCLick(article)
                }
            }
        }
    }
}