package com.akrasnoyarov.createyourmenu.api

import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeService {
    @GET("random.php")
    suspend fun getRandomRecipe(): Meals

    @GET("categories.php")
    suspend fun getCategories(): Categories

    @GET("filter.php?c={category}")
    suspend fun getRecipesByCategory(@Path("category") categoryName: String): MealsByCategory
}