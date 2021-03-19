package com.akrasnoyarov.createyourmenu.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {
    @GET("random.php")
    suspend fun getRandomRecipe(): Meals

    @GET("categories.php")
    suspend fun getCategories(): Categories

    @GET("filter.php")
    suspend fun getRecipesByCategory(@Query("c") categoryName: String): MealsByCategory

    @GET("lookup.php")
    suspend fun getRecipeById(@Query("i") id: Long): Meals
}