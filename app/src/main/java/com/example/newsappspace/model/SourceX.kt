package com.example.newsappspace.model


import com.google.gson.annotations.SerializedName

data class SourceX(
    @SerializedName("id")
    var id: String?,
    @SerializedName("name")
    var name: String?
)