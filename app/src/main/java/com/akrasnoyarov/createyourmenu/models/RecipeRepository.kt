package com.akrasnoyarov.createyourmenu.models

import android.content.Context
import android.util.Log
import com.akrasnoyarov.createyourmenu.api.MealDbService
import com.akrasnoyarov.createyourmenu.models.entiteis.Recipe
import com.akrasnoyarov.createyourmenu.utils.converters.RecipeConverter

class RecipeRepository(private val context: Context) {
    suspend fun getRecipe(): Recipe {
        val meals = MealDbService.recipesApi.getRandomRecipe()
        return RecipeConverter.convertRecipeToEntity(meals)
    }
}