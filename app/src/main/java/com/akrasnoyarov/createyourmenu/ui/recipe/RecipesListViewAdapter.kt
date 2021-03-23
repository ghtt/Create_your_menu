package com.akrasnoyarov.createyourmenu.ui.recipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akrasnoyarov.createyourmenu.databinding.RecipeItemBinding
import com.akrasnoyarov.createyourmenu.models.entities.RecipePreview
import com.bumptech.glide.Glide

class RecipesListViewAdapter(private val onRecipeClicked: (Long) -> Unit) :
    RecyclerView.Adapter<RecipesListViewAdapter.RecipeViewHolder>() {
    private var recipes: List<RecipePreview> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = RecipeItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.onBind(recipes[position])
    }

    override fun getItemCount(): Int = recipes.size

    fun submitRecipesList(newList: List<RecipePreview>) {
        recipes = newList
        notifyDataSetChanged()
    }


    inner class RecipeViewHolder(private val binding: RecipeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(recipe: RecipePreview) {
            Glide.with(binding.root.context)
                .load(recipe.imageUrl)
                .into(binding.recipeImageView)
            binding.recipeTextView.text = recipe.name
            binding.root.setOnClickListener { onRecipeClicked(recipe.id) }
        }
    }

}
