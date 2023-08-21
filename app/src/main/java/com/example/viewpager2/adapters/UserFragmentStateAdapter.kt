package com.example.viewpager2.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.viewpager2.fragments.ViewPagerFragment
import com.example.viewpager2.models.User

class UserFragmentStateAdapter(val list: ArrayList<User>, fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return ViewPagerFragment.newInstance(
            list[position].name.toString(),
            list[position].image.toString()
        )
    }
}