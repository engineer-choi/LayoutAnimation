package com.example.animationexercise.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animationexercise.ui.DetailActivity
import com.example.animationexercise.R
import kotlinx.android.synthetic.main.item_poster_line.view.*

class PosterLineAdapter : RecyclerView.Adapter<PosterLineAdapter.PosterViewHolder>() {

    private val items = mutableListOf<Poster>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PosterViewHolder(
            inflater.inflate(
                R.layout.item_poster_line,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PosterViewHolder, position: Int) {
        val item = items[position]
        holder.itemView.run {
            Glide.with(context)
                .load(item.poster)
                .into(item_poster_post)
            item_poster_title.text = item.name
            item_poster_running_time.text = item.playtime
            setOnClickListener {
                DetailActivity.startActivity(
                    context,
                    item_poster_line_transformationLayout,
                    item
                )
            }
        }
    }

    fun addPosterList(list: List<Poster>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount() = items.size

    class PosterViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
