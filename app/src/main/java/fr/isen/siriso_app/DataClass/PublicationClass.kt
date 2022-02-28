package fr.isen.siriso_app.DataClass

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class PublicationClass(
        val publication_name: String? = null,
        val publication_date: String? = null,
        val user_name: String? = null,
        val media_url: String? = null,
        val category: String? = null,
        val description: String? = null,
        val likes_count: Int? = 0
) {
    //
}