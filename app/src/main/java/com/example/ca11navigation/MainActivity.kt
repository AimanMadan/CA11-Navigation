package com.example.ca11navigation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.ca11navigation.Fragments.ChartFragment
import com.example.ca11navigation.Fragments.HomeFragment
import com.example.ca11navigation.Fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val chartFragment = ChartFragment()
        val settingsFragment = SettingsFragment()

        changeFragment(homeFragment)

        // Use setOnItemSelectedListener for BottomNavigationView instead of setOnClickListener
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.ic_home -> {
                    changeFragment(homeFragment)
                    true
                }
                R.id.ic_chart -> {
                    changeFragment(chartFragment)
                    true
                }
                R.id.ic_settings -> {
                    changeFragment(settingsFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fContainer, fragment)
            commit()
        }
    }
}
