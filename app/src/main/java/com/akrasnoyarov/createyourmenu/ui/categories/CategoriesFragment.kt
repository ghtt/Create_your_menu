package com.akrasnoyarov.createyourmenu.ui.categories

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.akrasnoyarov.createyourmenu.databinding.FragmentCategoriesBinding
import com.akrasnoyarov.createyourmenu.models.RecipeRepository
import com.akrasnoyarov.createyourmenu.ui.viewmodel.RecipeViewModel
import com.akrasnoyarov.createyourmenu.ui.viewmodel.RecipeViewModelFactory

class CategoriesFragment : Fragment() {
    private var _binding: FragmentCategoriesBinding? = null
    private val binding: FragmentCategoriesBinding get() = _binding!!
    private lateinit var viewModel: RecipeViewModel
    private lateinit var viewModelFactory: RecipeViewModelFactory
    private lateinit var categoriesViewAdapter: CategoriesViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("CategoriesFragment", "onCreateView")
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)

        initUI()
        initViewModel()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getCategories()
    }

    private fun initUI() {
        categoriesViewAdapter = CategoriesViewAdapter(::onCategoryClicked)
        binding.categoriesRecyclerView.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = categoriesViewAdapter
        }
    }

    private fun initViewModel() {
        viewModelFactory = RecipeViewModelFactory(RecipeRepository(requireContext()))
        viewModel = ViewModelProvider(this, viewModelFactory).get(RecipeViewModel::class.java)
        viewModel.categories.observe(viewLifecycleOwner) {
            categoriesViewAdapter.submitCategoriesList(it)
        }
    }


    private fun onCategoryClicked(categoryName: String) {
        Log.d("myLogs", "onClicked ${categoryName}")
        val action = CategoriesFragmentDirections
            .actionCategoriesFragmentToRecipesListFragment(categoryName)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = CategoriesFragment()
    }
}