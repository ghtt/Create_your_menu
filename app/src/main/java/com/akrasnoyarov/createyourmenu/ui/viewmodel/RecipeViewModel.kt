package com.akrasnoyarov.createyourmenu.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akrasnoyarov.createyourmenu.models.entiteis.Recipe
import com.akrasnoyarov.createyourmenu.models.RecipeRepository
import kotlinx.coroutines.launch

class RecipeViewModel(private val repository: RecipeRepository) : ViewModel() {
    private var _recipe = MutableLiveData<Recipe>()
    val recipe: LiveData<Recipe> get() = _recipe

    init {
        getRecipe()
    }

    fun getRecipe() {
        viewModelScope.launch {
            _recipe.postValue(repository.getRecipe())
        }
    }
}