package com.akrasnoyarov.createyourmenu.api

import com.google.gson.annotations.SerializedName

data class MealsByCategory(
	@field:SerializedName("meals")
	val items: List<Item?>? = null
)

data class Item(
	@field:SerializedName("strMealThumb")
	val strMealThumb: String? = null,

	@field:SerializedName("idMeal")
	val idMeal: String? = null,

	@field:SerializedName("strMeal")
	val strMeal: String? = null
)
