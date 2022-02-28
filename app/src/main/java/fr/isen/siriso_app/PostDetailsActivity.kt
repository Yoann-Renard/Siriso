package fr.isen.siriso_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.siriso_app.databinding.ActivityPostDetailsBinding

class PostDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityPostDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}