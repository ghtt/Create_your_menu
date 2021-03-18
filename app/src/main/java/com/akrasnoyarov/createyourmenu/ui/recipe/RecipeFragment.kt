package com.akrasnoyarov.createyourmenu.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.akrasnoyarov.createyourmenu.databinding.FragmentRecipeBinding
import com.akrasnoyarov.createyourmenu.models.RecipeRepository
import com.akrasnoyarov.createyourmenu.ui.ingredients.IngredientsViewAdapter
import com.akrasnoyarov.createyourmenu.ui.viewmodel.RecipeViewModel
import com.akrasnoyarov.createyourmenu.ui.viewmodel.RecipeViewModelFactory
import com.bumptech.glide.Glide

class RecipeFragment : Fragment() {
    private var _binding: FragmentRecipeBinding? = null
    private val binding: FragmentRecipeBinding get() = _binding!!

    private lateinit var viewModel: RecipeViewModel
    private lateinit var viewModelFactory: RecipeViewModelFactory
    private lateinit var ingredientsViewAdapter: IngredientsViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipeBinding.inflate(inflater, container, false)

        viewModelFactory = RecipeViewModelFactory(RecipeRepository(requireContext()))
        viewModel = ViewModelProvider(this, viewModelFactory).get(RecipeViewModel::class.java)
        initUI()

        return binding.root
    }


    private fun initUI() {
        viewModel.recipe.observe(viewLifecycleOwner) {
            setRecipeImage(it.imageUrl)
            binding.ingredientsRecyclerView.apply {
                adapter = IngredientsViewAdapter(it.ingredients)
                layoutManager = LinearLayoutManager(activity)
            }
            binding.nameTextView.text = it.name
            binding.stepsTextView.text = it.steps
        }
    }

    private fun setRecipeImage(image: String) {
        Glide.with(requireContext())
            .load(image)
            .into(binding.recipeImageView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(): RecipeFragment {
            return RecipeFragment()
        }
    }
}