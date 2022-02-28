package fr.isen.siriso_app.DataClass

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class CommentClass(
    val user: String? = null,
    val publication_date: String? = null,
    val content: String? = null,

    ){
    //
}
