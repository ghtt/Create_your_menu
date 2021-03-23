package com.akrasnoyarov.createyourmenu.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.akrasnoyarov.createyourmenu.databinding.FragmentRecipesListBinding
import com.akrasnoyarov.createyourmenu.models.RecipeRepository
import com.akrasnoyarov.createyourmenu.ui.viewmodel.RecipeViewModel
import com.akrasnoyarov.createyourmenu.ui.viewmodel.RecipeViewModelFactory


class RecipesListFragment : Fragment() {
    private var _binding: FragmentRecipesListBinding? = null
    private val binding: FragmentRecipesListBinding get() = _binding!!

    private lateinit var viewModel: RecipeViewModel
    private lateinit var viewModelFactory: RecipeViewModelFactory
    private lateinit var recipesAdapter: RecipesListViewAdapter
    private val args: RecipesListFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecipesListBinding.inflate(inflater, container, false)

        initUI()
        initViewModel()

        val categoryName = args.categoryName
        viewModel.getRecipesByCategory(categoryName)

        return binding.root
    }

    private fun initUI() {
        recipesAdapter = RecipesListViewAdapter(::onRecipeClicked)
        binding.recipesListRecyclerView.apply {
            adapter = recipesAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }
    }

    private fun initViewModel() {
        viewModelFactory = RecipeViewModelFactory(RecipeRepository(requireContext()))
        viewModel = ViewModelProvider(this, viewModelFactory).get(RecipeViewModel::class.java)
        viewModel.recipes.observe(viewLifecycleOwner) {
            recipesAdapter.submitRecipesList(it)
        }
    }

    private fun onRecipeClicked(recipeId: Long) {
        val action = RecipesListFragmentDirections
            .actionRecipesListFragmentToRecipeFragment(recipeId)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_CATEGORY = "category"
        fun newInstance(categoryName: String): RecipesListFragment {
            return RecipesListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_CATEGORY, categoryName)
                }
            }
        }
    }
}