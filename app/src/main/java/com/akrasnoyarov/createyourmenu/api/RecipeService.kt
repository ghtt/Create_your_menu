package com.akrasnoyarov.createyourmenu.api

import retrofit2.http.GET

interface RecipeService {
    @GET("random.php")
    suspend fun getRandomRecipe(): Meals

    @GET("categories.php")
    suspend fun getCategories(): Categories
}