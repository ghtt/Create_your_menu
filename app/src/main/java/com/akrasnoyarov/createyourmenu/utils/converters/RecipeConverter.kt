package com.akrasnoyarov.createyourmenu.utils.converters

import com.akrasnoyarov.createyourmenu.api.Item
import com.akrasnoyarov.createyourmenu.api.Meals
import com.akrasnoyarov.createyourmenu.api.MealsItem
import com.akrasnoyarov.createyourmenu.models.entiteis.Ingredient
import com.akrasnoyarov.createyourmenu.models.entiteis.Recipe
import com.akrasnoyarov.createyourmenu.models.entiteis.RecipePreview
import com.akrasnoyarov.createyourmenu.models.entiteis.Step


class RecipeConverter {
    companion object {
        fun convertRecipeToEntity(recipeFromApi: Meals): Recipe {
            val item = recipeFromApi.meals?.get(0)
            return Recipe(
                imageUrl = item?.strMealThumb!!,
                name = item.strMeal!!,
                steps = item.strInstructions!!,
                id = item.idMeal?.toLong()!!,
                ingredients = getIngredients(item)
            )
        }

        fun convertRecipePreviewToEntity(recipeItem: Item): RecipePreview {
            return RecipePreview(
                imageUrl = recipeItem.strMealThumb!!,
                name = recipeItem.strMeal!!,
                id = recipeItem.idMeal!!.toLong()
            )
        }

        private fun getCookingStep(instruction: String): List<Step> {
            val list = instruction.split("\r\n")
            val steps = mutableListOf<Step>()
            for ((number, step) in list.withIndex()) {
                steps.add(
                    Step(number + 1, step)
                )
            }
            return steps
        }

        private fun getIngredients(item: MealsItem): List<Ingredient> {
            val ingredientListFromItem = listOf(
                item.strIngredient1,
                item.strIngredient2,
                item.strIngredient3,
                item.strIngredient4,
                item.strIngredient5,
                item.strIngredient6,
                item.strIngredient7,
                item.strIngredient8,
                item.strIngredient9,
                item.strIngredient10,
                item.strIngredient11,
                item.strIngredient12,
                item.strIngredient13,
                item.strIngredient14,
                item.strIngredient15,
                item.strIngredient16,
                item.strIngredient17,
                item.strIngredient18,
                item.strIngredient19,
                item.strIngredient20
            )
            val measureListFromItem = listOf(
                item.strMeasure1,
                item.strMeasure2,
                item.strMeasure3,
                item.strMeasure4,
                item.strMeasure5,
                item.strMeasure6,
                item.strMeasure7,
                item.strMeasure8,
                item.strMeasure9,
                item.strMeasure10,
                item.strMeasure11,
                item.strMeasure12,
                item.strMeasure13,
                item.strMeasure14,
                item.strMeasure15,
                item.strMeasure16,
                item.strMeasure17,
                item.strMeasure18,
                item.strMeasure19,
                item.strMeasure20
            )
            val list = mutableListOf<Ingredient>()
            var index = 0
            while (index < ingredientListFromItem.size
                && !ingredientListFromItem.get(index).isNullOrEmpty()
            ) {
                list.add(
                    Ingredient(
                        ingredientListFromItem.get(index)!!,
                        measureListFromItem[index]!!,
                        item.idMeal!!.toLong()
                    )
                )
                index++
            }
            return list
        }
    }
}