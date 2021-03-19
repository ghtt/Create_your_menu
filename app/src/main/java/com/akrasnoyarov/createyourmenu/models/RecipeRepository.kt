package com.akrasnoyarov.createyourmenu.models

import android.content.Context
import com.akrasnoyarov.createyourmenu.api.MealDbService
import com.akrasnoyarov.createyourmenu.models.entities.Category
import com.akrasnoyarov.createyourmenu.models.entities.Recipe
import com.akrasnoyarov.createyourmenu.models.entities.RecipePreview
import com.akrasnoyarov.createyourmenu.utils.converters.CategoryConverter
import com.akrasnoyarov.createyourmenu.utils.converters.RecipeConverter

class RecipeRepository(private val context: Context) {
    suspend fun getRecipe(): Recipe {
        val meals = MealDbService.recipesApi.getRandomRecipe()
        return RecipeConverter.convertRecipeToEntity(meals)
    }

    suspend fun getCategories(): List<Category>? {
        val categories = MealDbService.recipesApi.getCategories()
        return categories.values?.map { CategoryConverter.convertCategoryToEntity(it!!) }
    }

    suspend fun getRecipesByCategory(categoryName: String): List<RecipePreview>? {
        val recipes = MealDbService.recipesApi.getRecipesByCategory(categoryName)
        return recipes.items?.map { RecipeConverter.convertRecipePreviewToEntity(it!!) }
    }
}