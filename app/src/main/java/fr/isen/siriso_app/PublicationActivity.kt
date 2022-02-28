package fr.isen.siriso_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.siriso_app.databinding.ActivityPublicationBinding

class PublicationActivity : AppCompatActivity() {
    lateinit var binding: ActivityPublicationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPublicationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}