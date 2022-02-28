package fr.isen.siriso_app.database

import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import fr.isen.siriso_app.DataClass.PublicationClass
import java.util.*

class DatabaseHandler {
    var database = Firebase.database("https://siriso-ad8e2-default-rtdb.europe-west1.firebasedatabase.app/")
    var myRef = database.getReference("publications")

    fun writeNewPublication(
        publication_name: String,
        user_name: String,
        media_url: String,
        category: String,
        description: String
    ) {
        val publicationDate = Calendar.getInstance().time.toString()
        val publicationId = UUID.randomUUID().toString();
        val publication = PublicationClass(
            publication_name = publication_name,
            user_name = user_name,
            media_url = media_url,
            category = category,
            description = description,
            publication_date = publicationDate
        )

        myRef.child(publicationId).setValue(publication)
    }

    /*
    writeNewPublication(
        publication_name = "char qui fly",
        user_name = "toto",
        media_url = "http.cat/100",
        category = "photography",
        description = "Juste un gros chat qui vole"
    )
    */

    fun getPublications() {
        myRef.get().addOnSuccessListener {
            Log.i("firebase", "Got value ${it.value}")
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }
    }
}