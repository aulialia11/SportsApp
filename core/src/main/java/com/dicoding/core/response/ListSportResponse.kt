package com.dicoding.core.response

import com.google.gson.annotations.SerializedName

data class ListSportResponse(

    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("sports")
    val places: List<SportResponse>
)