package com.example.meals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.meals.databinding.FragmentMealBinding
import androidx.recyclerview.widget.GridLayoutManager

class MealFragment: Fragment(), MealsAdapter.MealClickListner {

    lateinit var binding: FragmentMealBinding
    var meals: MutableList<Meal> = mutableListOf()
    lateinit var mealsAdapter: MealsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMealBinding.inflate(inflater, container, false)

        meals = mutableListOf(
            Meal(resources.getString(R.string.burger), R.drawable.burger),
            Meal(resources.getString(R.string.steak), R.drawable.steak),
            Meal(resources.getString(R.string.pancakes), R.drawable.pancakes),
            Meal(resources.getString(R.string.pizza), R.drawable.pizza),
            Meal(resources.getString(R.string.shawerma), R.drawable.shawerma),
            Meal(resources.getString(R.string.waffles), R.drawable.waffles),
            )

        mealsAdapter = MealsAdapter(meals,this)
        binding.rvMeals.adapter = mealsAdapter

        val gridLayoutManager = GridLayoutManager(context, 2)
        binding.rvMeals.layoutManager = gridLayoutManager

        return binding.root
    }

    override fun onMealClicked(meal: Meal) {
        val action = MealFragmentDirections.actionMealFragmentToMealDetailsFragment(meal)
        findNavController().navigate(action)
    }

}