package com.example.newsappspace.model


import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("articles")
    var articles: List<Article>?,
    @SerializedName("status")
    var status: String?,
    @SerializedName("totalResults")
    var totalResults: Int?
)