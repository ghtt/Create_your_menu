package com.akrasnoyarov.createyourmenu.models.entiteis

data class Recipe(
    val imageUrl: String,
    val name: String,
    val steps: String,
    val ingredients: List<Ingredient>,
    val id: Long
)
