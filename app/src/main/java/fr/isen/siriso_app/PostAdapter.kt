package fr.isen.siriso_app

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.isen.siriso_app.DataClass.PublicationClass
import fr.isen.siriso_app.databinding.CellPostBinding
import fr.isen.siriso_app.network.Publication

class PostAdapter(private val posts: ArrayList<PublicationClass>): RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    lateinit var context: Context

    class PostViewHolder(binding: CellPostBinding): RecyclerView.ViewHolder(binding.root){
        val title: TextView = binding.postTitle
        val user: TextView = binding.postUser
        val image: ImageView = binding.postImage
        val likes: TextView = binding.postLikes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        context = parent.context
        return PostViewHolder(CellPostBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val postItem = posts[position]
        holder.title.text = postItem.publication_name
        holder.user.text = postItem.user_name
        holder.likes.text = postItem.likes_count.toString()
        Picasso.get()
            .load(postItem.media_url)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return posts.count()
    }
}