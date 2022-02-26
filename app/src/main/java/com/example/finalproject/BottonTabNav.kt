package com.example.finalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.botton_tab_nav.*

class BottonTabNav: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.botton_tab_nav)

        setUpTabBar()
    }

    private fun setUpTabBar() {
        val adapter = TabPageAdapter(this,id_tabLayout.tabCount)
        viewPaper.adapter = adapter
        viewPaper.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback()
        {
            override fun onPageSelected(position: Int) {
                id_tabLayout.selectTab(id_tabLayout.getTabAt(position))
            }

        })
        id_tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener
        {


            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPaper.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

    }

}