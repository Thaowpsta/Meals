package com.example.meals

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.meals.databinding.ItemMealBinding
import com.example.meals.MealsAdapter.MyViewHolder


class MealsAdapter(val data: List<Meal>, val mealClickListener: MealClickListner)
    : ListAdapter<Meal, MyViewHolder>(UserItemDiffCallback()) {

    class MyViewHolder(val binding: ItemMealBinding): ViewHolder(binding.root) {
        companion object{
            fun from(parent: ViewGroup): MyViewHolder{
                val layout = LayoutInflater.from(parent.context)
                val binding = ItemMealBinding.inflate(layout, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    interface MealClickListner {
        fun onMealClicked(meal: Meal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.meal = data.get(position)
        holder.binding.img.setImageResource(data.get(position).imageId)
        holder.binding.root.setOnClickListener{
            mealClickListener.onMealClicked(data.get(position))
        }
    }
}

class UserItemDiffCallback: DiffUtil.ItemCallback<Meal>() {
    override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
        return oldItem == newItem
    }

}
