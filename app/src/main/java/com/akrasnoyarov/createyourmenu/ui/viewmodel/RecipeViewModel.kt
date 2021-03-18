package com.akrasnoyarov.createyourmenu.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akrasnoyarov.createyourmenu.models.entiteis.Recipe
import com.akrasnoyarov.createyourmenu.models.RecipeRepository
import com.akrasnoyarov.createyourmenu.models.entiteis.Category
import kotlinx.coroutines.launch

class RecipeViewModel(private val repository: RecipeRepository) : ViewModel() {
    private var _recipe = MutableLiveData<Recipe>()
    val recipe: LiveData<Recipe> get() = _recipe

    private var _categories = MutableLiveData<List<Category>>()
    val categories: LiveData<List<Category>> get() = _categories

    init {
        getRecipe()
        getCategories()
    }

    fun getRecipe() {
        viewModelScope.launch {
            _recipe.postValue(repository.getRecipe())
        }
    }

    fun getCategories() {
        viewModelScope.launch {
            _categories.postValue(repository.getCategories())
        }
    }
}