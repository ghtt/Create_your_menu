package com.akrasnoyarov.createyourmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.akrasnoyarov.createyourmenu.api.MealDbService
import com.akrasnoyarov.createyourmenu.api.Meals
import com.akrasnoyarov.createyourmenu.models.entiteis.Recipe
import com.akrasnoyarov.createyourmenu.utils.RecipeConverter
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}