package com.example.meals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.meals.databinding.FragmentMealDetailsBinding

class MealDetailsFragment : Fragment() {

    lateinit var binding: FragmentMealDetailsBinding
    private val args: MealDetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMealDetailsBinding.inflate(inflater, container, false)

        val meal = args.user

        binding.ivMeal.setImageResource(meal.imageId)
        binding.tvMeal.text = meal.title

        return binding.root
    }
}