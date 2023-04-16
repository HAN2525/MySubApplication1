package com.dicoding.picodiploma.mysubapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.picodiploma.mysubapplication.R

class UniversityAdapter(private val universities: ArrayList<University>) : RecyclerView.Adapter<UniversityAdapter.ViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_university, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val university = universities[position]
        holder.nameTextView.text = university.name
        holder.descriptionTextView.text = university.description
        holder.logoImageView.setImageResource(university.photo)

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(universities[holder.adapterPosition])
        }
    }

    override fun getItemCount() = universities.size

    fun getItem(position: Int) = universities[position]

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.tv_item_name)
        val descriptionTextView: TextView = itemView.findViewById(R.id.tv_item_description)
        val logoImageView: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: University)
    }
}