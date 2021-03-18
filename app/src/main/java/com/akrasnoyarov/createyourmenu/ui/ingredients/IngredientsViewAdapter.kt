package com.akrasnoyarov.createyourmenu.ui.ingredients

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akrasnoyarov.createyourmenu.databinding.IngredientItemBinding
import com.akrasnoyarov.createyourmenu.models.entiteis.Ingredient

class IngredientsViewAdapter(private var ingredients: List<Ingredient>) :
    RecyclerView.Adapter<IngredientsViewAdapter.IngredientsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientsViewHolder {
        val binding = IngredientItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return IngredientsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: IngredientsViewHolder, position: Int) {
        holder.onBind(ingredients[position])
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

    fun setIngredients(ingredients: List<Ingredient>) {
        this.ingredients = ingredients
        notifyDataSetChanged()
    }

    inner class IngredientsViewHolder(private val binding: IngredientItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(ingredient: Ingredient) {
            binding.apply {
                nameTextView.text = ingredient.name
                valueTextView.text = ingredient.value
            }
        }
    }
}