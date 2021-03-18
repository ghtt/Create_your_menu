package com.akrasnoyarov.createyourmenu.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)

        viewModelFactory = RecipeViewModelFactory(RecipeRepository(requireContext()))
        viewModel = ViewModelProvider(this, viewModelFactory).get(RecipeViewModel::class.java)

        initUI()

        return binding.root
    }

    private fun initUI() {
        viewModel.categories.observe(viewLifecycleOwner) {
            binding.categoriesRecyclerView.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = CategoriesViewAdapter(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = CategoriesFragment()
    }
}