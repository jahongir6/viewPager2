package com.example.viewpager2.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2.R
import com.example.viewpager2.databinding.ItemPagerBinding
import com.example.viewpager2.models.User

class UserAdapter(var list: List<User>) : RecyclerView.Adapter<UserAdapter.Vh>() {

    inner class Vh(val itemPagerBinding: ItemPagerBinding) :
        RecyclerView.ViewHolder(itemPagerBinding.root) {
        fun onBind(user: User) {
            itemPagerBinding.image.setImageResource(user.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}