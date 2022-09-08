package com.navin.snappfood

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.navin.snappfood.databinding.ActivityMainBinding
import com.navin.snappfood.ui.main.account.AccountFragment
import com.navin.snappfood.ui.main.adapter.TabsAdapter
import com.navin.snappfood.ui.main.home.HomeFragment
import com.navin.snappfood.ui.main.orders.OrdersFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val fragmentList: MutableList<Fragment> = ArrayList()
        fragmentList.add(AccountFragment())
        fragmentList.add(OrdersFragment())
        fragmentList.add(HomeFragment())
        val adapter = TabsAdapter(this, fragmentList)
        binding.viewPager2.setAdapter(adapter)
        binding.viewPager2.setUserInputEnabled(false);

        binding.viewPager2.setCurrentItem(2)
        binding.bottomMenu.menu.findItem(R.id.item_home).isChecked = true
        binding.bottomMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_home -> {
                    binding.viewPager2.setCurrentItem(2)
                    binding.bottomMenu.menu.findItem(R.id.item_home).isChecked = true
                }
                R.id.item_orders -> {
                    binding.viewPager2.setCurrentItem(1)
                    binding.bottomMenu.menu.findItem(R.id.item_orders).isChecked = true
                }
                R.id.item_account -> {
                    binding.viewPager2.setCurrentItem(0)
                    binding.bottomMenu.menu.findItem(R.id.item_account).isChecked = true
                }
            }
            false
        }


    }
}