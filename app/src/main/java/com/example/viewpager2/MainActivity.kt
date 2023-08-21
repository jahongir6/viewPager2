package com.example.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewpager2.adapters.UserAdapter
import com.example.viewpager2.adapters.UserFragmentStateAdapter
import com.example.viewpager2.databinding.ActivityMainBinding
import com.example.viewpager2.databinding.TabItemBinding
import com.example.viewpager2.models.User
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var list = ArrayList<User>()
    private lateinit var userAdapter: UserAdapter
    private lateinit var userFragmentStateAdapter: UserFragmentStateAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        userFragmentStateAdapter = UserFragmentStateAdapter(list, this)
        binding.viewPager2.adapter = userFragmentStateAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            val tabItem = TabItemBinding.inflate(layoutInflater)
            tabItem.tv.text = list[position].name
            tabItem.image.setImageResource(list[position].image)
            tab.text = list[position].name
            tab.customView = tabItem.root

        }.attach()

    }

    private fun loadData() {
        list = ArrayList()
        list.addAll(
            listOf(
                User(R.drawable.jahon, "jahongir1"),
                User(R.drawable.jahon2, "jahongir2"),
                User(R.drawable.jahon3, "jahhongir3"),
                User(R.drawable.jahon4, "jahongir4"),
            )
        )
    }
}