package com.akrasnoyarov.createyourmenu.ui

import androidx.fragment.app.Fragment
import com.akrasnoyarov.createyourmenu.ui.categories.CategoriesFragment
import com.akrasnoyarov.createyourmenu.ui.recipe.RecipeFragment
import com.akrasnoyarov.createyourmenu.ui.recipe.RecipesListFragment

class MainActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
//        return RecipeFragment.newInstance()
//        return CategoriesFragment.newInstance()
        return RecipesListFragment.newInstance("Chicken")
    }

}