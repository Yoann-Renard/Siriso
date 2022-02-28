package fr.isen.siriso_app.network

import com.google.gson.annotations.SerializedName

class Publication(
    @SerializedName("publication_name") val publication_name:String,
    @SerializedName("user_name") val user_name:String,
    @SerializedName("likes_count") val likes_count:Int,
    @SerializedName("media_url") val media_url:String
) {
    //
}