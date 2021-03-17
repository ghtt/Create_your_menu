package com.akrasnoyarov.createyourmenu.ui

import androidx.fragment.app.Fragment
import com.akrasnoyarov.createyourmenu.ui.recipe.RecipeFragment

class MainActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return RecipeFragment.newInstance()
    }
}