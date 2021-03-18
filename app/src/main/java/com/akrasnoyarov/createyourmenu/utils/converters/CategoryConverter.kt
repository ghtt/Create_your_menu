package com.akrasnoyarov.createyourmenu.utils.converters

import com.akrasnoyarov.createyourmenu.api.CategoriesItem
import com.akrasnoyarov.createyourmenu.models.entiteis.Category

class CategoryConverter {
    companion object {
        fun convertCategoryToEntity(categoryItem: CategoriesItem) =
            Category(
                id = categoryItem.idCategory!!.toLong(),
                name = categoryItem.strCategory!!,
                imageUrl = categoryItem.strCategoryThumb!!,
                description = categoryItem.strCategoryDescription!!
            )
    }
}