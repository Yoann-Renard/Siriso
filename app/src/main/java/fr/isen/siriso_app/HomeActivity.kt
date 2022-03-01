package fr.isen.siriso_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import fr.isen.siriso_app.DataClass.PublicationClass
import fr.isen.siriso_app.DataClass.Publications
import fr.isen.siriso_app.databinding.ActivityHomeBinding
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    var database = Firebase.database("https://siriso-ad8e2-default-rtdb.europe-west1.firebasedatabase.app/")
    var myRef = database.getReference("publications")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getPublications()
    }

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
        /*myRef.get().addOnSuccessListener {
            Log.i("firebase", "Got value ${it.value}")
            val data = it.getValue(Publications::class.java)
            if (data != null) {
                parseData(data.publications)
            }
        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }*/
        myRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val publicationsList = arrayListOf<PublicationClass>()
                snapshot.children.forEach {
                    it.getValue(PublicationClass::class.java)
                        ?.let { it1 -> publicationsList.add(it1) }
                }
                parseData(publicationsList)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("test", "erreur")
            }
        })
    }

    fun parseData(pubList: ArrayList<PublicationClass> ) {
        binding.postsList.layoutManager = LinearLayoutManager(this)
        binding.postsList.adapter = PostAdapter(pubList)
    }
}