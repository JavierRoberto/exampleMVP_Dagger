package com.example.examplemvp.http.apimodel
import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2019 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class Data(

    @SerializedName("id") val id: Double,
    @SerializedName("user_id") val user_id: Int,
    @SerializedName("user_name") val user_name: String,
    @SerializedName("game_id") val game_id: Int,
    @SerializedName("community_ids") val community_ids: List<String>,
    @SerializedName("type") val type: String,
    @SerializedName("title") val title: String,
    @SerializedName("viewer_count") val viewer_count: Int,
    @SerializedName("started_at") val started_at: String,
    @SerializedName("language") val language: String,
    @SerializedName("thumbnail_url") val thumbnail_url: String,
    @SerializedName("tag_ids") val tag_ids: List<String>
)