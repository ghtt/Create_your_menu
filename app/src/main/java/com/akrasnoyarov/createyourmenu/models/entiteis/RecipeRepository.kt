package com.akrasnoyarov.createyourmenu.models.entiteis

import android.content.Context
import com.akrasnoyarov.createyourmenu.api.MealDbService
import com.akrasnoyarov.createyourmenu.utils.RecipeConverter

class RecipeRepository(private val context: Context) {
    suspend fun getRecipe(): Recipe {
        val meals = MealDbService.recipesApi.getRandomRecipe()
        return RecipeConverter.convertRecipeToEntity(meals)
    }
}