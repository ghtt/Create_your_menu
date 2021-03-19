package com.akrasnoyarov.createyourmenu.ui.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akrasnoyarov.createyourmenu.databinding.CategoryItemBinding
import com.akrasnoyarov.createyourmenu.models.entities.Category
import com.bumptech.glide.Glide

class CategoriesViewAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoriesViewAdapter.CategoryViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesViewAdapter.CategoryViewHolder {
        val binding = CategoryItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesViewAdapter.CategoryViewHolder, position: Int) {
        holder.onBind(categories[position])
    }

    override fun getItemCount() = categories.size

    class CategoryViewHolder(val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(category: Category) {
            binding.apply {
                Glide.with(binding.root.context)
                    .load(category.imageUrl)
                    .into(categoryImage)
                categoryDescription.text = category.description
                categoryTitleTextview.text = category.name
            }
        }
    }

}
