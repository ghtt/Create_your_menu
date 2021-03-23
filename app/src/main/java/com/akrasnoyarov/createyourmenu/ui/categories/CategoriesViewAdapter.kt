package com.akrasnoyarov.createyourmenu.ui.categories

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akrasnoyarov.createyourmenu.databinding.CategoryItemBinding
import com.akrasnoyarov.createyourmenu.models.entities.Category
import com.bumptech.glide.Glide

class CategoriesViewAdapter(
    private val onCategoryClicked: (String) -> Unit
) :
    RecyclerView.Adapter<CategoriesViewAdapter.CategoryViewHolder>() {

    private var categories: List<Category> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val binding = CategoryItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.onBind(categories[position])
    }

    override fun getItemCount() = categories.size

    fun submitCategoriesList(newCategories: List<Category>) {
        this.categories = newCategories
        notifyDataSetChanged()
    }

    inner class CategoryViewHolder(val binding: CategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(category: Category) {
            binding.apply {
                Glide.with(binding.root.context)
                    .load(category.imageUrl)
                    .into(categoryImage)
                categoryDescription.text = category.description
                categoryTitleTextview.text = category.name

            }
            binding.root.setOnClickListener {
                onCategoryClicked(category.name)
            }
        }
    }
}
